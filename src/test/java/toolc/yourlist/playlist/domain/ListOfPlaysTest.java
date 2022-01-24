package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListOfPlaysTest {
  @Test
  void constructor() {
    var actual = new ListOfPlays(
      Arrays.asList(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .title("So Good Music")
          .videoId("abcd1234")
          .thumbnail("panda.png")
          .sequence(3L)
          .playTime(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(1L)
          .title("So Sad Music")
          .videoId("qwer1234")
          .thumbnail("puppy.png")
          .sequence(1L)
          .playTime(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(3L)
          .playlistId(1L)
          .title("So Funny Music")
          .videoId("zxcv1234")
          .thumbnail("cat.png")
          .sequence(2L)
          .playTime(new PlayTime(3000L, 25000L))
          .channel(new Channel("Music man", "mike.png"))
          .build()));

    var expected = new ListOfPlays(
      Arrays.asList(
        Play.builder()
          .id(2L)
          .playlistId(1L)
          .title("So Sad Music")
          .videoId("qwer1234")
          .thumbnail("puppy.png")
          .sequence(1L)
          .playTime(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(3L)
          .playlistId(1L)
          .title("So Funny Music")
          .videoId("zxcv1234")
          .thumbnail("cat.png")
          .sequence(2L)
          .playTime(new PlayTime(3000L, 25000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .title("So Good Music")
          .videoId("abcd1234")
          .thumbnail("panda.png")
          .sequence(3L)
          .playTime(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build()));
    assertThat(actual, is(expected));
  }

  @Test
  void 다른_영상목록의_영상_포함() {
    assertThrows(NotInEqualPlaylistException.class, () -> new ListOfPlays(
      Arrays.asList(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .title("So Good Music")
          .videoId("abcd1234")
          .thumbnail("panda.png")
          .sequence(1L)
          .playTime(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(2L)
          .title("So Sad Music")
          .videoId("qwer1234")
          .thumbnail("puppy.png")
          .sequence(2L)
          .playTime(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build())));
  }

  @Test
  void 영상들_순서_중복() {
    assertThrows(DuplicateSeqException.class, () -> new ListOfPlays(
      Arrays.asList(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .title("So Good Music")
          .videoId("abcd1234")
          .thumbnail("panda.png")
          .sequence(1L)
          .playTime(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(1L)
          .title("So Sad Music")
          .videoId("qwer1234")
          .thumbnail("puppy.png")
          .sequence(1L)
          .playTime(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build())));
  }
}