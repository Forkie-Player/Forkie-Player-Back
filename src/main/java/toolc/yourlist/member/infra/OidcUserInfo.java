package toolc.yourlist.member.infra;

import java.util.Map;

public abstract class OidcUserInfo {
  protected Map<String, Object> attributes;

  public OidcUserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  public abstract String getId();
}
