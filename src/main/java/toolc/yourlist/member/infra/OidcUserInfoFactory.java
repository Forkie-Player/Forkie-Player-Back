package toolc.yourlist.member.infra;

import java.util.Map;

public class OidcUserInfoFactory {
  public static OidcUserInfo getOAuth2UserInfo(Provider providerType, Map<String, Object> attributes) {
    return switch (providerType) {
      case GOOGLE -> new GoogleOidcUserInfo(attributes);
      case KAKAO -> new KakaoOidcUserInfo(attributes);
      // TODO: Custom Exception으로 바꾸기
      default -> throw new IllegalArgumentException("Invalid Provider Type.");
    };
  }
}
