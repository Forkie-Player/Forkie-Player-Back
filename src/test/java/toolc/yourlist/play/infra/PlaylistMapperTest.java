package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.PlaylistJson;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.PlaylistFixture.playlist;
import static toolc.yourlist.PlaylistFixture.playlistJson;

class PlaylistMapperTest {
  PlaylistMapper mapper = new PlaylistMapper();

  @Test
  void playlistJson로_변환() {
    PlaylistJson playlistJson = mapper.toPlaylistJson(playlist().build(), "thumbnail");

    assertThat(playlistJson, is(playlistJson().build()));
  }

  @Test
  void playlist가_null() {
    assertThrows(IllegalArgumentException.class, () ->
      mapper.toPlaylistJson(null, "thumbnail")
    );
  }
}