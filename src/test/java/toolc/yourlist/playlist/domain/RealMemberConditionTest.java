package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.UserType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RealMemberConditionTest {

  @Test
  void check() {
    var condition = new RealMemberCondition();

    var actual =
      condition.check(new User(UserType.MEMBER, 1L));

    assertThat(actual, is(true));
  }

  @Test
  void check_non_member() {
    var condition = new RealMemberCondition();

    var actual =
      condition.check(new User(UserType.VISITOR, 1L));

    assertThat(actual, is(false));
  }
}