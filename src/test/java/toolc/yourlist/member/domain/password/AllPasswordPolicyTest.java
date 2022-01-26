package toolc.yourlist.member.domain.password;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AllPasswordPolicyTest {

  @Test
  void should_be_satisfied_all_password_policy() {
    PasswordPolicy allPasswordPolicy = new AllPasswordPolicy();

    assertThat(allPasswordPolicy.matches("PasswordTest1!"), is(true));
  }
}