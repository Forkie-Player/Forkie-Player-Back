package toolc.yourlist.member.domain.loginId;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StartLowerCaseTest {


  @Test
  void start_lower_case() {
    LoginIdPolicy startLowerCase = new StartLowerCase();

    assertThat(startLowerCase.matches("jisoo01"), is(true));
  }
}