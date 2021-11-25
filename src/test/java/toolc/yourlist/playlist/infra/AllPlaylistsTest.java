package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AllPlaylistsTest {

  @Test
  void 멤버Id_불일치() {
    assertThrows(IllegalArgumentException.class, () -> new AllPlaylists(
      List.of(
        new PlaylistEntity(1L, "My List"),
        new PlaylistEntity(2L, "Other List"))));
  }
}