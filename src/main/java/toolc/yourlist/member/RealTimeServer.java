package toolc.yourlist.member;

import java.time.ZonedDateTime;

public class RealTimeServer implements TimeServer {

  @Override
  public ZonedDateTime nowTime() {
    return ZonedDateTime.now();
  }
}
