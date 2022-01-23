package toolc.yourlist.remember;

import java.time.ZonedDateTime;

public class FakeTimeServer implements TimeServer {

  ZonedDateTime fakeNowTime = ZonedDateTime.now();

  @Override
  public ZonedDateTime nowTime() {
    return fakeNowTime;
  }
}
