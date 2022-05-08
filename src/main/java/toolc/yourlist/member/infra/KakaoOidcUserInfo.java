package toolc.yourlist.member.infra;

import java.util.Map;

public class KakaoOidcUserInfo extends OidcUserInfo {

  public KakaoOidcUserInfo(Map<String, Object> attributes) {
    super(attributes);
  }

  @Override
  public String getId() {
    return (String) attributes.get("id");
  }
}
