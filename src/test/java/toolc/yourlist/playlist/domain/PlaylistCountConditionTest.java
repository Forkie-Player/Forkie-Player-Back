package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistCountConditionTest {
  @Test
  void check() {
    var condition = new PlaylistCountCondition();

    var actual = condition.check(2L);

    assertThat(actual, is(true));
  }

  @Test
  void check_exceed() {
    var condition = new PlaylistCountCondition();

    var actual = condition.check(3L);

    assertThat(actual, is(false));
  }
}