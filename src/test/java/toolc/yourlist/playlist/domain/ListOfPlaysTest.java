package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ListOfPlaysTest {
  @Test
  void 다른_영상목록의_영상_포함() {
    assertThrows(NotInEqualPlaylistException.class, () -> new ListOfPlays(
      List.of(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .title("So Good Music")
          .videoId("abcd1234")
          .thumbnail("panda.png")
          .playTime(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(2L)
          .title("So Sad Music")
          .videoId("qwer1234")
          .thumbnail("puppy.png")
          .playTime(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build())));
  }
}