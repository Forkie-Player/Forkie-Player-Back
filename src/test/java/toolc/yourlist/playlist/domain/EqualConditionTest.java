package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.exception.NotInEqualPlaylistException;
import toolc.yourlist.playlist.domain.exception.NotOwnerException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EqualConditionTest {
  @Test
  void 영상목록의_주인X() {
    var condition = new EqualCondition();

    assertThrows(NotOwnerException.class, () -> condition.checkMember(
      Member.builder()
        .id(1L)
        .isMember(true)
        .loginId("oh980225")
        .password("qwer1234!")
        .build(),
      Playlist.builder()
        .id(1L)
        .memberId(2L)
        .title("My List")
        .thumbnail("panda.png")
        .build()
    ));
  }

  @Test
  void 같은_영상목록_내_영상X() {
    var condition = new EqualCondition();

    assertThrows(NotInEqualPlaylistException.class, () -> condition.checkPlaylist(
      Playlist.builder()
        .id(1L)
        .memberId(2L)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Play.builder()
        .id(1L)
        .playlistId(2L)
        .time(new PlayTime(1000L, 120000L))
        .sequence(1L)
        .info(new PlayInfo("웃긴 영상", "abcd1234", "panda.png"))
        .channel(new Channel("smileMan", "smile.png"))
        .build()
    ));
  }
}