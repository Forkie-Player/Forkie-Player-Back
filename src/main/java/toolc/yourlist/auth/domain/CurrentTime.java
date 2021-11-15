package toolc.yourlist.auth.domain;

import lombok.Getter;

import java.time.Instant;

class CurrentTime {
  @Getter
  private final Instant now = Instant.now();
}
