package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RealMemberConditionTest {
  @Test
  void check() {
    var condition = new RealMemberCondition();

    var actual =
      condition.check(new Member(1L, "oh980225", true, "qwer1234!"));

    assertThat(actual, is(true));
  }

  @Test
  void check_non_member() {
    var condition = new RealMemberCondition();

    var actual =
      condition.check(new Member(1L, "oh980225", false, "qwer1234!"));

    assertThat(actual, is(false));
  }
}