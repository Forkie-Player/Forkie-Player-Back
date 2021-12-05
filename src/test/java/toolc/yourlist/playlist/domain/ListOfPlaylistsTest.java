package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ListOfPlaylistsTest {

  @Test
  void 멤버Id_불일치() {
    assertThrows(IllegalArgumentException.class, () -> new ListOfPlaylists(
      List.of(
        new Playlist(1L, 1L, "My List", "panda.png"),
        new Playlist(2L, 2L, "Other List", "puppy.jpeg"))));
  }
}