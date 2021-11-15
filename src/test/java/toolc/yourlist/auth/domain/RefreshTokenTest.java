package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RefreshTokenTest {

  @Test
  void equals() {
    Instant expirationTime = Instant.now();

    assertThat(new RefreshToken(expirationTime), is(new RefreshToken(expirationTime)));
  }

  @Test
  void refresh_token_validated_30_days_if_device_is_PC() {
    CurrentTime currentTime = new CurrentTime();
    RefreshTokenCreator refreshTokenCreator = new RefreshTokenCreator(currentTime);

    assertThat(refreshTokenCreator.create(Device.PC),
      is(new RefreshToken(currentTime.now().plus(Duration.ofDays(30)))));
  }

  @Test
  void refresh_token_validated_7_days_if_device_is_APP() {
    CurrentTime currentTime = new CurrentTime();
    RefreshTokenCreator refreshTokenCreator = new RefreshTokenCreator(currentTime);

    assertThat(refreshTokenCreator.create(Device.APP),
      is(new RefreshToken(currentTime.now().plus(Duration.ofDays(7)))));
  }
}