package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AccessTokenTest {


  @Test
  void equals() {
    Instant expirationTime = Instant.now();

    assertThat(new AccessToken(new LoginId("loginid1"), expirationTime),
      is(new AccessToken(new LoginId("loginid1"), expirationTime)));
  }

  @Test
  void token_validated_30_minutes() {
    CurrentTime currentTime = new CurrentTime();
    AccessTokenCreator accessTokenCreator = new AccessTokenCreator(currentTime);

    assertThat(accessTokenCreator.create(new LoginId("loginid1")),
      is(new AccessToken(new LoginId("loginid1"), currentTime.now().plus(Duration.ofMinutes(30)))));
  }
}