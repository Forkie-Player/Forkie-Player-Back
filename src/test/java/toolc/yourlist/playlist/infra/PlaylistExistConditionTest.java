package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PlaylistExistConditionTest {
  @Test
  void 영상목록_존재() {
    PlaylistExistCondition condition = new PlaylistExistCondition(MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(
        Optional.of(
          PlaylistEntity.builder()
            .memberId(1L)
            .title("My List")
            .build())))
      .build());

    var actual = condition.check(1L);

    var expected = new Playlist(
      Optional.of(
        PlaylistEntity.builder()
          .memberId(1L)
          .title("My List")
          .build()));
    assertThat(actual.get(), is(expected));
  }

  @Test
  void 영상목록_존재X() {
    PlaylistExistCondition condition = new PlaylistExistCondition(MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(
        Optional.empty()))
      .build());

    var actual = condition.check(1L);

    assertThat(actual.getLeft(), is("존재하지 않는 영상 목록입니다."));
  }
}