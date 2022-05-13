package toolc.yourlist.member.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import toolc.yourlist.common.infra.ResponseBody;
import toolc.yourlist.member.domain.TokenProvider;
import toolc.yourlist.member.domain.UserType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
public class OAuthAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private final TokenProvider tokenProvider;
  private final JpaAllMemberEntity jpaAllMemberEntity;

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

      successOAuth(response, entity);
      return;
    }

    successOAuth(response, entityOptional.get());
  }

  private void successOAuth(HttpServletResponse response, MemberEntity memberEntity) throws IOException {
    response.setStatus(HttpStatus.OK.value());
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    var token = tokenProvider.makeToken(memberEntity.id(), true, UserType.MEMBER);
    var responseBody = ResponseBody.builder()
      .status(HttpStatus.OK.value())
      .data(token)
      .message("OAuth 인증 성공")
      .build();

    PrintWriter out = response.getWriter();
    out.print(new ObjectMapper().writeValueAsString(responseBody));
    out.flush();
  }
}
