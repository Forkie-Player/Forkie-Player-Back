package toolc.yourlist.member.domain.loginId;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LengthLimitTest {

  @Test
  void length_limited_from_6_to_30() {
    LoginIdPolicy lengthLimit = new LengthLimit();

    assertThat(lengthLimit.matches("jisoo01"), is(true));
  }
}