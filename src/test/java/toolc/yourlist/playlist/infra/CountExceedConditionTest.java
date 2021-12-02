package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CountExceedConditionTest {
  class MockReadPersisting implements ReadPersisting {

    @Override
    public AllPlaylists readAllBelongsTo(Long memberId) {
      return null;
    }

    @Override
    public Playlist readBelongsTo(Long id) {
      return null;
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 3L;
    }
  }

  class MockReadPersistingForExceed implements ReadPersisting {

    @Override
    public AllPlaylists readAllBelongsTo(Long memberId) {
      return null;
    }

    @Override
    public Playlist readBelongsTo(Long id) {
      return null;
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 5L;
    }
  }

  @Test
  void check() {
    var condition = new CountExceedCondition(new MockReadPersisting());

    var actual = condition.check(1L);

    assertThat(actual, is(true));
  }

  @Test
  void check_exceed() {
    var condition = new CountExceedCondition(new MockReadPersistingForExceed());

    var actual = condition.check(1L);

    assertThat(actual, is(false));
  }
}