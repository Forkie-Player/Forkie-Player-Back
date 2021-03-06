package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.ThumbnailChangeChecker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ThumbnailChangeCheckerTest {
  @Test
  void check_for_first_play() {
    var checker = new ThumbnailChangeChecker();

    var actual = checker.checkSizeOne(1L);

    assertThat(actual, is(true));
  }

  @Test
  void check_for_change_sequence() {
    var checker = new ThumbnailChangeChecker();

    var actual = checker.check(3L, 0L);

    assertThat(actual, is(true));
  }

  @Test
  void check_for_empty_playlist() {
    var checker = new ThumbnailChangeChecker();

    var actual = checker.checkSizeZero(0L);

    assertThat(actual, is(true));
  }
}