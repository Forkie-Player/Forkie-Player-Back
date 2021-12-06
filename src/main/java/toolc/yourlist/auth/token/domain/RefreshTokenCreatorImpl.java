package toolc.yourlist.auth.token.domain;

import lombok.RequiredArgsConstructor;

import java.time.Duration;

@RequiredArgsConstructor
public class RefreshTokenCreatorImpl implements RefreshTokenCreator {
  private final CurrentTime currentTime;
  private final Duration PC_EXPIRATION_DATE = Duration.ofDays(30);
  private final Duration APP_EXPIRATION_DATE = Duration.ofDays(7);

  public RefreshToken create(Device device) {
    return new RefreshToken(currentTime.now().plus(
      device == Device.PC ? PC_EXPIRATION_DATE : APP_EXPIRATION_DATE));
  }

}

