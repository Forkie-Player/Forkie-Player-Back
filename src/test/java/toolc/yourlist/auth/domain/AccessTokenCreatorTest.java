package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AccessTokenCreatorTest {

  @Test
  void token_validated_30_minutes() {
    CurrentTime currentTime = new CurrentTime();
    AccessTokenCreator accessTokenCreator = new AccessTokenCreatorImpl(currentTime);

    assertThat(accessTokenCreator.create(new LoginId("jisoo27")),
      is(new AccessToken(new LoginId("jisoo27"),
        currentTime.now().plus(Duration.ofMinutes(30)))));
  }

}