package toolc.yourlist.member.infra;

import java.util.Map;

public class KakaoOAuthUserInfo extends OAuthUserInfo {

  public KakaoOAuthUserInfo(Map<String, Object> attributes) {
    super(attributes);
  }

  @Override
  public String getId() {
    return Long.toString((Long) attributes.get("id"));
  }
}
