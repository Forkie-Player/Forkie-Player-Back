package toolc.yourlist.auth.token.domain;

import java.time.Instant;

public class RealTimeServer implements CurrentTimeServer {

  @Override
  public Instant now() {
    return Instant.now();
  }
}
