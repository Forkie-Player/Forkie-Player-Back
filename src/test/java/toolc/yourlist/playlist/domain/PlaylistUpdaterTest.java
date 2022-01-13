package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlaylistUpdaterTest {
  @Test
  void updateTitle_not_equal_owner() {
    var allPlaylists = new MockAllPlaylists();
    var updater = new PlaylistUpdater(allPlaylists);
    var request = new UpdateRequest(Member.builder()
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
        .build(),
      "New List");

    assertThrows(NotOwnerException.class, () -> updater.updateTitle(request));
  }
}