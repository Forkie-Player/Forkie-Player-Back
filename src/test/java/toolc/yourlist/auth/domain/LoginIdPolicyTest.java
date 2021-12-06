package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LoginIdPolicyTest {

  @Test
  void non_null() {
    LoginIdPolicy nonNull = new NonNull();

    assertThat(nonNull.matches("jisoo01"), is(true));
  }

  @Test
  void allow_only_lower_case_or_number() {
    LoginIdPolicy allowOnlyLowerCaseOrNumber = new AllowOnlyLowerCaseOrNumber();

    assertThat(allowOnlyLowerCaseOrNumber.matches("jisoo01"), is(true));
  }

  @Test
  void length_limited_from_5_to_20() {
    LoginIdPolicy lengthLimit = new LengthLimit();

    assertThat(lengthLimit.matches("jisoo01"), is(true));
  }

  @Test
  void start_lower_case() {
    LoginIdPolicy startLowerCase = new StartLowerCase();

    assertThat(startLowerCase.matches("jisoo01"), is(true));
  }

  @Test
  void should_be_satisfied_all_loginId_policy() {
    LoginIdPolicy allLoginIdPolicy = new All();

    assertThat(allLoginIdPolicy.matches("jisoo01"), is(true));
  }

}