package toolc.yourlist.member.domain.password;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NonNullTest {

  @Test
  void password_non_null() {
    PasswordPolicy nonNull = new NonNull();

    assertThat(nonNull.matches("Password1!"), is(true));
  }
}