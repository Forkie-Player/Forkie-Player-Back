package toolc.yourlist.auth.token.domain;

import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
public class TokenExpirationConfig {
  private final CurrentTimeServer currentTimeServer;

  private final Duration ACCESS_ALL_EXPIRATION = Duration.ofMinutes(30);
  private final Duration REFRESH_PC_EXPIRATION = Duration.ofDays(30);
  private final Duration REFRESH_APP_EXPIRATION = Duration.ofDays(7);


  public Instant accessTokenExpirationTime() {
    return currentTimeServer.now().plus(ACCESS_ALL_EXPIRATION);
  }

  public Instant refreshTokenExpirationTime(boolean isPC) {

    return currentTimeServer.now().plus(
      isPC ? REFRESH_PC_EXPIRATION : REFRESH_APP_EXPIRATION);
  }


}
