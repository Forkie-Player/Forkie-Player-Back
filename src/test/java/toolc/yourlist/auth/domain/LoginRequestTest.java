package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

class LoginRequestTest {

  @Test
  void equals() {
    assertThat(
      new LoginRequest(new LoginId("jisoo27"),
        new Password("q1w2e3r4!@"), Device.PC),
      is(
        new LoginRequest(new LoginId("jisoo27"),
          new Password("q1w2e3r4!@"), Device.PC))
    );
  }
}