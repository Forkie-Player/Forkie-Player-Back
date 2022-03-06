package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static toolc.yourlist.member.domain.UserType.VISITOR;

class SavePolicyTest {

  @Test
  void match_non_member_and_exceed_playlist() {
    var policy = new SavePolicy();

    var actual = policy.match(new User(VISITOR, 1L), 5L);

    assertThat(actual, is(false));
  }
}