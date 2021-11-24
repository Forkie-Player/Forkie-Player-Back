package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class EqualOwnerConditionTest {
  @Test
  void 영상목록의_주인O() {
    EqualOwnerCondition condition = new EqualOwnerCondition(MockPersistingPlaylist.builder()
      .readBelongsTo(id ->
        new Playlist(
          Optional.of(
            PlaylistEntity.builder()
              .title("List Title")
              .memberId(1L)
              .build())))
      .build());

    var actual = condition.check(1L, 1L);
    assertThat(actual, is(true));
  }

  @Test
  void 영상목록의_주인X() {
    EqualOwnerCondition condition = new EqualOwnerCondition(MockPersistingPlaylist.builder()
      .readBelongsTo(id ->
        new Playlist(
          Optional.of(
            PlaylistEntity.builder()
              .title("List Title")
              .memberId(1L)
              .build())))
      .build());

    var actual = condition.check(2L, 1L);
    assertThat(actual, is(false));
  }
}