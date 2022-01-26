package toolc.yourlist.member;

import java.time.ZonedDateTime;

public class FakeTimeServer implements TimeServer {

  ZonedDateTime fakeNowTime = ZonedDateTime.now();

  @Override
  public ZonedDateTime nowTime() {
    return fakeNowTime;
  }
}
