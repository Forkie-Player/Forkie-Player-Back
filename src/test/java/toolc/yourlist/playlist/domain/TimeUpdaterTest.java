package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


@ExtendWith(MockitoExtension.class)
class TimeUpdaterTest {
  @Test
  void update(@Mock AllPlay allPlay) {
    var updater = new TimeUpdater(allPlay);
    var request = new TimeUpdateRequest(new EqualMemberForPlay(
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
        .thumbnail("panda.png")
        .build(),
      Play.builder()
        .id(1L)
        .playlistId(1L)
        .sequence(1L)
        .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
        .time(new PlayTime(1000L, 3000L))
        .channel(new Channel("Music man", "man.png"))
        .build()
    ), new PlayTime(2000L, 4000L));

    updater.update(request);
    verify(allPlay).updateTime(
      request.equalMemberForPlay().play().id(),
      request.time());
    verifyNoMoreInteractions(allPlay);
  }
}