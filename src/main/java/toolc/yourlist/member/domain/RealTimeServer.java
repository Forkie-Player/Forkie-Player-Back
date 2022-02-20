package toolc.yourlist.member.domain;

import java.time.Instant;

public class RealTimeServer implements TimeServer {

  @Override
  public Instant nowTime() {
    return Instant.now();
  }
}
