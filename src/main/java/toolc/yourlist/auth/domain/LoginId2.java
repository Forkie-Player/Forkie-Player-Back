package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public final class LoginId2 {
  String raw;

  public LoginId2(String raw) {
    if (raw == null || raw.equals("")) {
      throw new IllegalArgumentException();
    }
    this.raw = raw;
  }
}
