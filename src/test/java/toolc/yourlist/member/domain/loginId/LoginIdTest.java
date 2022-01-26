package toolc.yourlist.member.domain.loginId;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class LoginIdTest {

  @Test
  void equals() {
    assertThat(new LoginId("jisoo98"), Matchers.is(new LoginId("jisoo98")));
  }

}