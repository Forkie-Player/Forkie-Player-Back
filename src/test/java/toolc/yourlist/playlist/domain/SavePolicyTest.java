package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SavePolicyTest {

  @Test
  void match_non_member_and_exceed_playlist() {
    var policy = new SavePolicy();

    var actual = policy.match(Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(false)
        .build(),
      5L);

    assertThat(actual, is(false));
  }
}