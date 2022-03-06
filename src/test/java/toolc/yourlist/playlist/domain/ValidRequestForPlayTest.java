package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.UserType;
import toolc.yourlist.playlist.domain.exception.NotInEqualPlaylistException;
import toolc.yourlist.playlist.domain.exception.NotOwnerException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.member.domain.UserType.MEMBER;
import static toolc.yourlist.member.domain.UserType.VISITOR;

class ValidRequestForPlayTest {
  @Test
  void not_equal_owner() {
    assertThrows(NotOwnerException.class, () -> new ValidRequestForPlay(
      new User(VISITOR, 1L),
      Playlist.builder()
        .id(1L)
        .userCode("MEMBER_1")
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Play.builder()
        .id(1L)
        .playlistId(1L)
        .sequence(1L)
        .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
        .time(new PlayTime(1000L, 3000L))
        .channel(new Channel("Music man", "man.png"))
        .build()));
  }

  @Test
  void not_equal_playlist() {
    assertThrows(NotInEqualPlaylistException.class, () -> new ValidRequestForPlay(
      new User(MEMBER, 1L),
      Playlist.builder()
        .id(1L)
        .userCode("MEMBER_1")
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Play.builder()
        .id(1L)
        .playlistId(2L)
        .sequence(1L)
        .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
        .time(new PlayTime(1000L, 3000L))
        .channel(new Channel("Music man", "man.png"))
        .build()));
  }
}
