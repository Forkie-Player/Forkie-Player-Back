package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ListOfPlaylistsTest {
  @Test
  void 멤버Id_불일치() {
    assertThrows(IllegalArgumentException.class, () -> new ListOfPlaylists(
      List.of(
        Playlist.builder()
          .id(1L)
          .memberId(1L)
          .title("My List")
          .thumbnail("panda.png")
          .build(),
        Playlist.builder()
          .id(2L)
          .memberId(2L)
          .title("Other List")
          .thumbnail("puppy.png")
          .build())));
  }
}