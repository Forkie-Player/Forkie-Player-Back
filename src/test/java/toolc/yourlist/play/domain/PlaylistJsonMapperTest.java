package toolc.yourlist.play.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.PlaylistFixture.playlist;
import static toolc.yourlist.PlaylistFixture.playlistEntity;

class PlaylistJsonMapperTest {
  PlaylistMapper mapper = new PlaylistMapper();

  @Test
  void playlist로_변환() {
    PlaylistJson playlist = mapper.toPlaylistJson(playlistEntity().build(), "thumbnail");

    assertThat(playlist, is(playlist().build()));
  }

  @Test
  void playlistEntitiy가_null() {
    assertThrows(IllegalArgumentException.class, () ->
      mapper.toPlaylistJson(null, "thumbnail")
    );
  }
}