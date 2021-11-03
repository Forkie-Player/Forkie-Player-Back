package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginId2Test {

  @Test
  void Should_Be_Same_When_Raw_Is_Same() {
    assertThat(new LoginId2("jisoo98"), is(new LoginId2("jisoo98")));
  }

  @Test
  void Raw_Should_Be_Non_Null(){
    assertThrows(IllegalArgumentException.class, () -> new LoginId2(null));
  }
}