package toolc.yourlist.member.infra;

import java.util.Map;

public class GoogleOidcUserInfo extends OidcUserInfo {
  public GoogleOidcUserInfo(Map<String, Object> attributes) {
    super(attributes);
  }

  @Override
  public String getId() {
    return (String) attributes.get("sub");
  }
}
