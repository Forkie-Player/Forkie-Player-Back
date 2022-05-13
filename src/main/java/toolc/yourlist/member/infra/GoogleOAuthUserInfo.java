package toolc.yourlist.member.infra;

import java.util.Map;

public class GoogleOAuthUserInfo extends OAuthUserInfo {
  public GoogleOAuthUserInfo(Map<String, Object> attributes) {
    super(attributes);
  }

  @Override
  public String getId() {
    return (String) attributes.get("sub");
  }
}
