package toolc.yourlist.member.domain.loginId;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AllowLowerCaseOrNumberTest {

  @Test
  void allow_only_lower_case_or_number() {
    LoginIdPolicy allowOnlyLowerCaseOrNumber = new AllowLowerCaseOrNumber();

    assertThat(allowOnlyLowerCaseOrNumber.matches("jisoo01"), is(true));
  }
}