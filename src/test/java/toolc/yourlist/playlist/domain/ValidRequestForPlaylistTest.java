package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.UserType;
import toolc.yourlist.playlist.domain.exception.NotOwnerException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidRequestForPlaylistTest {
  @Test
  void not_equal_owner() {
    assertThrows(NotOwnerException.class, () -> new ValidRequestForPlaylist(
      new User(UserType.VISITOR, 1L),
      Playlist.builder()
        .id(1L)
        .userCode("MEMBER_1")
        .title("My List")
        .thumbnail("panda.png")
        .build()));
  }
}