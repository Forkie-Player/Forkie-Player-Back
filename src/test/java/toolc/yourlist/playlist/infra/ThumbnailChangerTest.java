package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.MockAllPlaylists;

class ThumbnailChangerTest {
  @Test
  void change_for_first_play() {
    var changer = new ThumbnailChanger(new MockAllPlaylists());

    changer.change(1L, "puppy.png", 0L);
  }
}