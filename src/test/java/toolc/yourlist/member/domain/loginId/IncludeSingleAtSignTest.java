package toolc.yourlist.member.domain.loginId;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IncludeSingleAtSignTest {

  @Test
  void length_limited_from_6_to_30() {
    LoginIdPolicy includeSingleAtSign = new IncludeSingleAtSign();

    assertThat(includeSingleAtSign.matches("ritty1234@gmail.com"), is(true));
  }
}