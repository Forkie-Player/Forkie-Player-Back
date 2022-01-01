package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.token.domain.Device;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class NonMemberLoginRequestTest {

  @Test
  void equals() {
    assertThat(new NonMemberLoginRequest("qwer1234baced-dfg123", true),
      is(new NonMemberLoginRequest("qwer1234baced-dfg123", true)));
  }

  @Test
  void non_null() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest(null, true));
  }

  @Test
  void non_empty() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest("", true));
  }
}