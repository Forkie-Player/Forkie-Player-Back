package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ListOfPlaysTest {
  @Test
  void 다른_영상목록의_영상_포함() {
    assertThrows(NotInEqualPlaylistException.class, () -> new ListOfPlays(
      Arrays.asList(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
          .sequence(0L)
          .time(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(2L)
          .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
          .sequence(1L)
          .time(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build())));
  }

  @Test
  void 영상들_순서_이상_중복된_경우() {
    assertThrows(InvalidSeqException.class, () -> new ListOfPlays(
      Arrays.asList(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
          .sequence(0L)
          .time(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(1L)
          .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
          .sequence(0L)
          .time(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build())));
  }

  @Test
  void 영상들_순서_이상_정렬X_경우() {
    assertThrows(InvalidSeqException.class, () -> new ListOfPlays(
      Arrays.asList(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
          .sequence(1L)
          .time(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(1L)
          .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
          .sequence(0L)
          .time(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build())));
  }
}