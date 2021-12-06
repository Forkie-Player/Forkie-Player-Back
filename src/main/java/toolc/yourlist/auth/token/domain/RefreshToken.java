package toolc.yourlist.auth.token.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;

@EqualsAndHashCode
@Getter
public final class RefreshToken {
  private final Instant expirationAt;

  public RefreshToken(Instant expirationAt) {
    this.expirationAt = expirationAt;
  }
}