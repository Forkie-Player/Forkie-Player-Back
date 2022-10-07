package toolc.yourlist.member.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import toolc.yourlist.member.domain.MemberAuthProvider;
import toolc.yourlist.member.domain.MemberRegisterAndLoginRequest;
import toolc.yourlist.member.domain.Token;
import toolc.yourlist.member.domain.TokenProvider;
import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class OAuthAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final MemberAuthProvider memberAuthProvider;

  @Value("${oauth.redirectUrl}")
  private String redirectUrl;


  // OAuth시 PC인지 아닌지 알 수가 없다...
  // TODO: 추후에 해결해야할 듯
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
    Provider provider = Provider.valueOf(authToken.getAuthorizedClientRegistrationId().toUpperCase());
    System.out.println(provider);
    System.out.println(authentication);

    var entityOptional = jpaAllMemberEntity
      .findByLoginIdAndProvider(authToken.getName(), provider);

    var registerAndLoginRequest = new MemberRegisterAndLoginRequest(
      new LoginId(authToken.getName()),
      new Password(authToken.getName()),
      true,
      provider);

    if (entityOptional.isEmpty()) {
      successOAuth(request, response, getToken(memberAuthProvider.registerMember(registerAndLoginRequest)));
      return;
    }

    successOAuth(request, response, getToken(memberAuthProvider.getMemberToken(registerAndLoginRequest)));
  }

  private void successOAuth(HttpServletRequest request, HttpServletResponse response, Token token) throws IOException {
    getRedirectStrategy().sendRedirect(request, response, redirectUrl + "?accessToken=" + token.accessToken() + "&refreshToken=" + token.refreshToken());
  }

  private Token getToken(Either<String, Token> either) {
    if (either.isEmpty()) {
      throw new RuntimeException("OAuth2 관련 문제가 발생하였습니다.");
    }

    return either.get();
  }
}
