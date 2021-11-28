package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AllPlaylistsTest {

  @Test
  void 멤버Id_불일치() {
    assertThrows(IllegalArgumentException.class, () -> new AllPlaylists(
      List.of(
        new Playlist(1L, 1L, "My List"),
        new Playlist(2L, 2L, "Other List"))));
  }
}