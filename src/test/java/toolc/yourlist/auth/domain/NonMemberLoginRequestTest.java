package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;


import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class NonMemberLoginRequestTest {

  AuthExpiration authExpiration = new AuthExpiration(Instant.now().plus(30, ChronoUnit.MINUTES)
    , Instant.now().plus(60, ChronoUnit.MINUTES));

  @Test
  void equals() {
    assertThat(new NonMemberLoginRequest(
      "qwer1234baced-dfg123", authExpiration, "PC" + 10L),
      is(new NonMemberLoginRequest(
        "qwer1234baced-dfg123", authExpiration, "PC" + 10L)));
  }

  @Test
  void non_null() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest(null, null, null));
  }

  @Test
  void non_empty() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest("", authExpiration, "PC" + 10L));
  }
}