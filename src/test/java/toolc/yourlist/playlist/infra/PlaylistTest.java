package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

  @Test
  void 없는_영상목록() {
    assertThrows(IllegalArgumentException.class, () -> new Playlist(Optional.empty()));
  }
}