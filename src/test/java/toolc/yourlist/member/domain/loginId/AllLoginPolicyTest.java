package toolc.yourlist.member.domain.loginId;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AllLoginPolicyTest {
  @Test
  void should_be_satisfied_all_loginId_policy() {
    LoginIdPolicy allLoginIdPolicy = new AllLoginPolicy();

    assertThat(allLoginIdPolicy.matches("ritty1234@gmail.com"), is(true));
  }
}