package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;


import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class NonMemberLoginRequestTest {

  InfoForToken infoForToken = new InfoForToken(
    new AuthExpiration(Instant.now().plus(30, ChronoUnit.MINUTES)
      , Instant.now().plus(60, ChronoUnit.MINUTES)), "PC");

  @Test
  void equals() {
    assertThat(new NonMemberLoginRequest(
        "qwer1234baced-dfg123", infoForToken),
      is(new NonMemberLoginRequest(
        "qwer1234baced-dfg123", infoForToken)));
  }

  @Test
  void non_null() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest(null, infoForToken));
  }

  @Test
  void non_empty() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest("", infoForToken));
  }
}