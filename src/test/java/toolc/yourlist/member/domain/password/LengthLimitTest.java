package toolc.yourlist.member.domain.password;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LengthLimitTest {
  @Test
  void length_limited_from_6_to_20() {
    PasswordPolicy lengthLimit = new LengthLimit();

    assertThat(lengthLimit.matches("Password1@"), is(true));
  }

}