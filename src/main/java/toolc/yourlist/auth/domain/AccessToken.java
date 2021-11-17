package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;

@EqualsAndHashCode
@Getter
public final class AccessToken {
  private final LoginId loginId;
  private final Instant expirationAt;

  AccessToken(LoginId loginId, Instant expirationAt) {
    this.loginId = loginId;
    this.expirationAt = expirationAt;
  }
}