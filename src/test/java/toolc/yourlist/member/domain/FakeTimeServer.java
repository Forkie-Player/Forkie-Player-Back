package toolc.yourlist.member.domain;

import java.time.Instant;

public class FakeTimeServer implements TimeServer {

  private final Instant now;

  public FakeTimeServer(Instant now) {
    this.now = now;
  }

  @Override
  public Instant nowTime() {
    return now;
  }
}
