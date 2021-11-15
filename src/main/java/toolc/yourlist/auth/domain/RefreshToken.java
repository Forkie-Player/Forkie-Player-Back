package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode
public class RefreshToken {
  private final Instant expirationAt;

  public RefreshToken(Instant expirationAt) {
    this.expirationAt = expirationAt;
  }
}
