package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LoginId2Test {

  @Test
  void Should_Be_Same_When_Raw_Is_Same() {
    assertThat(new LoginId2("jisoo98"), is(new LoginId2("jisoo98")));
  }


}