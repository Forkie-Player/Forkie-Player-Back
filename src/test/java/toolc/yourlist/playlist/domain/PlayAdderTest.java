package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PlayAdderTest {
  @Test
  void add(@Mock AllPlay allPlay, @Mock ChangeThumbnail changeThumbnail) {
    var adder = new PlayAdder(allPlay, changeThumbnail);
    var validRequestForPlaylist = new ValidRequestForPlaylist(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build(),
      Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .build());
    var info = new PlayInfo("Good Music", "abcd1234", "panda.png");
    var time = new PlayTime(10000L, 130000L);
    var channel = new Channel("Music man", "man.png");
    var request = new AddPlayRequest(validRequestForPlaylist, info, time, channel);
    var playlistSize = 0L;
    given(allPlay.havingCountOf(1L)).willReturn(playlistSize);

    adder.add(request);

    verify(allPlay).havingCountOf(validRequestForPlaylist.get().id());
    verify(allPlay).save(
      Play.builder()
        .info(info)
        .playlistId(validRequestForPlaylist.get().id())
        .sequence(playlistSize  )
        .time(time)
        .channel(channel)
        .build());
    verify(changeThumbnail).changeForMakingFirstPlay(validRequestForPlaylist.get().id(), info.thumbnail());
    verifyNoMoreInteractions(allPlay);
    verifyNoMoreInteractions(changeThumbnail);
  }
}