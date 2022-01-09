package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LoginRequestTest {

  InfoForToken infoForToken = new InfoForToken(
    new AuthExpiration(Instant.now().plus(30, ChronoUnit.MINUTES)
      , Instant.now().plus(60, ChronoUnit.MINUTES)), "PC");


  @Test
  void equals() {
    assertThat(
      new LoginRequest(new LoginId("jisoo27"),
        new Password("q1w2e3r4!@"), infoForToken),
      is(
        new LoginRequest(new LoginId("jisoo27"),
          new Password("q1w2e3r4!@"), infoForToken))
    );
  }
}