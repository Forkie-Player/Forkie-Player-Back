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
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOidcService extends OidcUserService {
  private final JpaAllMemberEntity jpaAllMemberEntity;

  @Override
  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User user = super.loadUser(userRequest);
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

    OidcUserInfo userInfo = OidcUserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());
    var memberEntity = jpaAllMemberEntity
      .findByLoginIdAndProvider(userInfo.getId(), providerType);

    if (memberEntity.isEmpty()) {
      jpaAllMemberEntity.save(new MemberEntity(userInfo.getId(), userInfo.getId(), providerType));
    }

    return new UserPrincipal(userInfo.getId());
  }
}
