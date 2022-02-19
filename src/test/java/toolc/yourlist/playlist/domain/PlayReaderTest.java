package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayReaderTest {
  @Test
  void readAllPlays(@Mock AllPlay allPlay) {
    var reader = new PlayReader(allPlay);
    var request = new ReadAllPlaysRequest(new ValidRequestForPlaylist(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qewr1234!")
        .isMember(true)
        .build(),
      Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build()));

    when(allPlay.readAllBelongsTo(request.validRequestForPlaylist().get().id()))
      .thenReturn(new Plays(
        List.of(
          Play.builder()
            .id(1L)
            .playlistId(request.validRequestForPlaylist().get().id())
            .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
            .sequence(0L)
            .time(new PlayTime(1000L, 10000L))
            .channel(new Channel("Music man", "mike.png"))
            .build(),
          Play.builder()
            .id(2L)
            .playlistId(request.validRequestForPlaylist().get().id())
            .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
            .sequence(1L)
            .time(new PlayTime(1500L, 20000L))
            .channel(new Channel("Music man", "mike.png"))
            .build())));

    var expected = new Plays(
      List.of(
        Play.builder()
          .id(1L)
          .playlistId(request.validRequestForPlaylist().get().id())
          .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
          .sequence(0L)
          .time(new PlayTime(1000L, 10000L))
          .channel(new Channel("Music man", "mike.png"))
          .build(),
        Play.builder()
          .id(2L)
          .playlistId(request.validRequestForPlaylist().get().id())
          .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
          .sequence(1L)
          .time(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build()));

    var actual = reader.readAllPlays(request);

    assertThat(actual, is(expected));
    verify(allPlay).readAllBelongsTo(request.validRequestForPlaylist().get().id());
    verifyNoMoreInteractions(allPlay);
  }
}
