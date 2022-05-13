package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RequiredArgsConstructor
public class CustomOAuthService extends DefaultOAuth2UserService {
  private final JpaAllMemberEntity jpaAllMemberEntity;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
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
    OAuthUserInfo userInfo = OAuthUserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());
    var memberEntity = jpaAllMemberEntity
      .findByLoginIdAndProvider(userInfo.getId(), providerType);

    if (memberEntity.isEmpty()) {
      jpaAllMemberEntity.save(new MemberEntity(userInfo.getId(), userInfo.getId(), providerType));
    }

    return new UserPrincipal(userInfo.getId());
  }
}
