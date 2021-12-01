package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LoginIdConditionTest {
  @Test
  void check() {
    var condition = new LoginIdCondition();

    var actual = condition.check("oh980225");

    assertThat(actual.get(), is(new LoginId2("oh980225")));
  }

  @Test
  void check_null() {
    var condition = new LoginIdCondition();

    var actual = condition.check(null);
    assertThat(actual.getLeft(), is("null값은 허용하지 않습니다."));
  }

  @Test
  void check_differ_policy() {
    var condition = new LoginIdCondition();

    var actual = condition.check("5");
    assertThat(actual.getLeft(), is("잘못된 LoginId 입니다."));
  }
}