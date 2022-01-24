package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ListOfPlaylistsTest {
  @Test
  void 동일하지_않은_멤버의_영상목록들() {
    assertThrows(NotEqualOwnerForPlaylistsException.class, () -> new ListOfPlaylists(
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