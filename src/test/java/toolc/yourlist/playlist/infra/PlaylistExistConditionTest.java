package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.Playlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PlaylistExistConditionTest {
  @Test
  void 영상목록_존재() {
    PlaylistExistCondition condition = new PlaylistExistCondition(MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(1L, "My List"))
      .build());

    var actual = condition.check(1L);

    var expected = new Playlist(1L, "My List");
    assertThat(actual.get(), is(expected));
  }

  @Test
  void 영상목록_존재X() {
    PlaylistExistCondition condition = new PlaylistExistCondition(MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(null, null))
      .build());

    var actual = condition.check(1L);

    assertThat(actual.getLeft(), is("존재하지 않는 영상 목록입니다."));
  }
}