package toolc.yourlist.member.domain.password;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class PasswordTest {

  @Test
  void equals() {
    assertThat(new Password("password1227!"),
      Matchers.is(new Password("password1227!")));
  }
}