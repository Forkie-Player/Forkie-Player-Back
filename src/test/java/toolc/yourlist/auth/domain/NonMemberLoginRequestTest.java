package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class NonMemberLoginRequestTest {

  @Test
  void equals() {
    assertThat(new NonMemberLoginRequest("qwer1234baced-dfg123", Device.APP),
      is(new NonMemberLoginRequest("qwer1234baced-dfg123", Device.APP)));
  }

  @Test
  void non_null() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest(null, Device.APP));
  }

  @Test
  void non_empty() {
    assertThrows(IllegalArgumentException.class,
      () -> new NonMemberLoginRequest("", Device.APP));
  }
}