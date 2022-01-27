package toolc.yourlist.member.domain;

import toolc.yourlist.member.domain.TimeServer;

import java.time.ZonedDateTime;

public class FakeTimeServer implements TimeServer {

  ZonedDateTime fakeNowTime = ZonedDateTime.now();

  @Override
  public ZonedDateTime nowTime() {
    return fakeNowTime;
  }
}
