package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public final class LoginId {
  @Getter
  private final String raw;

  LoginId(String raw) {
    this.raw = raw;
  }
}