package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RequiredArgsConstructor
public class CustomOidcService extends OidcUserService {

  @Override
  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User user = super.loadUser(userRequest);
    System.out.println("This?");
    try {
      return this.process(userRequest, user);
    } catch (AuthenticationException ex) {
      throw ex;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
    }
  }

  private OidcUser process(OAuth2UserRequest userRequest, OAuth2User user) {
    Provider providerType = Provider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());

    System.out.println(user.getAttributes());
    OidcUserInfo userInfo = OidcUserInfoFactory.getOidcUserInfo(providerType, user.getAttributes());

    return new UserPrincipal(userInfo.getId());
  }
}
