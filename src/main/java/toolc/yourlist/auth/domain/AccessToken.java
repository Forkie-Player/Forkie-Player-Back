package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;

@EqualsAndHashCode
@Getter
public final class AccessToken {
  private final String identifier;
  private final Instant expirationAt;

  AccessToken(String identifier, Instant expirationAt) {
    this.identifier = identifier;
    this.expirationAt = expirationAt;
  }
}
