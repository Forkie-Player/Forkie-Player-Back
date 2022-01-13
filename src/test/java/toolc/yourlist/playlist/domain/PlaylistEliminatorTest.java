package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlaylistEliminatorTest {
  @Test
  void delete_not_equal_owner() {
    var allPlaylists = new MockAllPlaylists();
    var eliminator = new PlaylistEliminator(allPlaylists);
    var request = new DeleteRequest(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build(),
      Playlist.builder()
        .id(1L)
        .memberId(2L)
        .title("My List")
        .thumbnail("panda.png")
        .build());

    assertThrows(NotOwnerException.class, () -> eliminator.delete(request));
  }
}