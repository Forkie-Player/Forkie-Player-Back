package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode
class AccessToken {
  private final LoginId loginId;
  private final Instant expirationAt;

  public AccessToken(LoginId loginId, Instant expirationAt) {
    this.loginId = loginId;
    this.expirationAt = expirationAt;
  }
}
