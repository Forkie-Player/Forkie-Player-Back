package toolc.yourlist.member.domain;

import java.time.ZonedDateTime;

public class RealTimeServer implements TimeServer {

  @Override
  public ZonedDateTime nowTime() {
    return ZonedDateTime.now();
  }
}
