package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.exception.NotOwnerException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidRequestForPlaylistTest {
  @Test
  void not_equal_owner() {
    assertThrows(NotOwnerException.class, () -> new ValidRequestForPlaylist(
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
        .build()));
  }
}