package toolc.yourlist.remember;

import java.time.ZonedDateTime;

class RealTimeServer implements TimeServer {

  @Override
  public ZonedDateTime nowTime() {
    return ZonedDateTime.now();
  }
}
