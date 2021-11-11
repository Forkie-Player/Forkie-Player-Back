package toolc.yourlist.auth.domain.request;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class PasswordTest {

  @Test
  void equals() {
    assertThat(new Password("password1227!"), is(new Password("password1227!")));
  }
}