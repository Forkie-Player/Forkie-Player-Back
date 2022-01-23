package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.ThumbnailChangeChecker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ThumbnailChangeCheckerTest {
  @Test
  void check_for_first_play() {
    var checker = new ThumbnailChangeChecker();

    var actual = checker.check(0);

    assertThat(actual, is(true));
  }
}