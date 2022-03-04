package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static toolc.yourlist.member.domain.UserType.MEMBER;

@ExtendWith(MockitoExtension.class)
class SequenceUpdaterTest {
  @Test
  void update(@Mock AllPlay allPlay, @Mock ChangeThumbnail changeThumbnail) {
    var updater = new SequenceUpdater(allPlay, changeThumbnail);
    var request = new PlaySequencesForUpdate(
      List.of(
        new PlaySequence(
          new ValidRequestForPlay(
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
              .sequence(0L)
              .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
              .time(new PlayTime(1000L, 3000L))
              .channel(new Channel("Music man", "man.png"))
              .build()), 1L),
        new PlaySequence(
          new ValidRequestForPlay(
            new User(MEMBER, 1L),
            Playlist.builder()
              .id(1L)
              .userCode("MEMBER_1")
              .title("My List")
              .thumbnail("panda.png")
              .build(),
            Play.builder()
              .id(2L)
              .playlistId(1L)
              .sequence(1L)
              .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
              .time(new PlayTime(2000L, 3000L))
              .channel(new Channel("Music man", "man.png"))
              .build()), 0L)));

    updater.update(request);

    verify(allPlay, times(1)).updateSequence(1L, 1L);
    verify(changeThumbnail).changeForUpdateSequence(
      Play.builder()
        .id(1L)
        .playlistId(1L)
        .sequence(0L)
        .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
        .time(new PlayTime(1000L, 3000L))
        .channel(new Channel("Music man", "man.png"))
        .build(),
      1L
    );
    verify(allPlay, times(1)).updateSequence(2L, 0L);
    verify(changeThumbnail, times(1)).changeForUpdateSequence(
      Play.builder()
        .id(2L)
        .playlistId(1L)
        .sequence(1L)
        .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
        .time(new PlayTime(2000L, 3000L))
        .channel(new Channel("Music man", "man.png"))
        .build(),
      0L
    );
    verifyNoMoreInteractions(allPlay);
    verifyNoMoreInteractions(changeThumbnail);
  }

  @Test
  void updateWithDelete(@Mock AllPlay allPlay, @Mock ChangeThumbnail changeThumbnail) {
    var updater = new SequenceUpdater(allPlay, changeThumbnail);
    updater.updateWithDelete(new Plays(
      List.of(
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
          .sequence(1L)
          .time(new PlayTime(1500L, 20000L))
          .channel(new Channel("Music man", "mike.png"))
          .build())), 0L);

    verify(allPlay, times(1)).updateSequence(2L, 0L);
    verify(changeThumbnail, times(1)).changeForUpdateSequence(Play.builder()
      .id(2L)
      .playlistId(1L)
      .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
      .sequence(1L)
      .time(new PlayTime(1500L, 20000L))
      .channel(new Channel("Music man", "mike.png"))
      .build(), 0L);
    verifyNoMoreInteractions(allPlay);
    verifyNoMoreInteractions(changeThumbnail);
  }
}