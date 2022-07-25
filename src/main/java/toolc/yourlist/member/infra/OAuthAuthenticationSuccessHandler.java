package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import toolc.yourlist.member.domain.TokenProvider;
import toolc.yourlist.member.domain.UserType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class OAuthAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private final TokenProvider tokenProvider;
  private final JpaAllMemberEntity jpaAllMemberEntity;

  @Value("${oauth.redirectUrl}")
  private String redirectUrl;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
    Provider provider = Provider.valueOf(authToken.getAuthorizedClientRegistrationId().toUpperCase());
    System.out.println(provider);
    System.out.println(authentication);

    var entityOptional = jpaAllMemberEntity
      .findByLoginIdAndProvider(authToken.getName(), provider);

    if (entityOptional.isEmpty()) {
      var entity = jpaAllMemberEntity
        .save(new MemberEntity(authToken.getName(), authToken.getName(), provider));

      successOAuth(request, response, entity);
      return;
    }

    successOAuth(request, response, entityOptional.get());
  }

  // OAuth시 PC인지 아닌지 알 수가 없다...
  // TODO: 추후에 해결해야할 듯
  private void successOAuth(HttpServletRequest request, HttpServletResponse response, MemberEntity memberEntity) throws IOException {
    var token = tokenProvider.makeToken(memberEntity.id(), true, UserType.MEMBER);

    getRedirectStrategy().sendRedirect(request, response, redirectUrl + "?accessToken=" + token.accessToken() + "&refreshToken=" + token.refreshToken());
  }
}
