package toolc.yourlist.member.infra;

import java.util.Map;

public class OAuthUserInfoFactory {
  public static OAuthUserInfo getOAuth2UserInfo(Provider providerType, Map<String, Object> attributes) {
    return switch (providerType) {
      case GOOGLE -> new GoogleOAuthUserInfo(attributes);
      case KAKAO -> new KakaoOAuthUserInfo(attributes);
      // TODO: Custom Exception으로 바꾸기
      default -> throw new IllegalArgumentException("Invalid Provider Type.");
    };
  }
}
