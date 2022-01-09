package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LoginRequestTest {

  AuthExpiration authExpiration = new AuthExpiration(Instant.now().plus(30, ChronoUnit.MINUTES)
    , Instant.now().plus(60, ChronoUnit.MINUTES));

  Long id = 321L;


  @Test
  void equals() {
    assertThat(
      new LoginRequest(new LoginId("jisoo27"),
        new Password("q1w2e3r4!@"), authExpiration, "PC" + id),
      is(
        new LoginRequest(new LoginId("jisoo27"),
          new Password("q1w2e3r4!@"), authExpiration, "PC" + id))
    );
  }
}