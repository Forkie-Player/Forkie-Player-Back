package toolc.yourlist.member.domain.loginId;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NonNullTest {
  @Test
  void non_null() {
    LoginIdPolicy nonNull = new NonNull();

    assertThat(nonNull.matches("jspark111"), is(true));
  }
}