package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.PlaylistJson;
import toolc.yourlist.play.infra.PlaylistMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.PlaylistFixture.playlistJson;
import static toolc.yourlist.PlaylistFixture.playlistEntity;

class PlaylistMapperTest {
  PlaylistMapper mapper = new PlaylistMapper();

  @Test
  void playlistJson로_변환() {
    PlaylistJson playlistJson = mapper.toPlaylistJson(playlistEntity().build(), "thumbnail");

    assertThat(playlistJson, is(playlistJson().build()));
  }

  @Test
  void playlistEntitiy가_null() {
    assertThrows(IllegalArgumentException.class, () ->
      mapper.toPlaylistJson(null, "thumbnail")
    );
  }
}