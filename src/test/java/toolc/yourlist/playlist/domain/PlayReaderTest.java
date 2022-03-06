package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.UserType;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static toolc.yourlist.member.domain.UserType.MEMBER;

@ExtendWith(MockitoExtension.class)
class PlayReaderTest {
  @Test
  void readAllPlays(@Mock AllPlay allPlay) {
    var reader = new PlayReader(allPlay);
    var request = new ReadAllPlaysRequest(new ValidRequestForPlaylist(
      new User(MEMBER, 1L),
      Playlist.builder()
        .id(1L)
        .userCode("MEMBER_1")
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
