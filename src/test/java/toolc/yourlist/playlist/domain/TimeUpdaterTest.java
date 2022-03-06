package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.UserType;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static toolc.yourlist.member.domain.UserType.MEMBER;


@ExtendWith(MockitoExtension.class)
class TimeUpdaterTest {
  @Test
  void update(@Mock AllPlay allPlay) {
    var updater = new TimeUpdater(allPlay);
    var request = new TimeUpdateRequest(new ValidRequestForPlay(
      new User(MEMBER, 1L),
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
        .build()
    ), new PlayTime(2000L, 4000L));

    updater.update(request);
    verify(allPlay).updateTime(
      request.validRequestForPlay().get().id(),
      request.time());
    verifyNoMoreInteractions(allPlay);
  }
}