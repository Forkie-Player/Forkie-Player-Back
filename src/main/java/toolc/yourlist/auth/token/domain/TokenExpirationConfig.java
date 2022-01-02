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


  Instant accessTokenExpirationTime() {
    return currentTimeServer.now().plus(ACCESS_ALL_EXPIRATION);
  }

  Instant refreshTokenExpirationTime(Device device) {

    return currentTimeServer.now().plus(
      device == Device.PC ? REFRESH_PC_EXPIRATION : REFRESH_APP_EXPIRATION);
  }


}
