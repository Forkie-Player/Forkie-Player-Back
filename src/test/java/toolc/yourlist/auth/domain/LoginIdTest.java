package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LoginIdTest {

  @Test
  void equals() {
    assertThat(new LoginId("jisoo98"), is(new LoginId("jisoo98")));
  }

}