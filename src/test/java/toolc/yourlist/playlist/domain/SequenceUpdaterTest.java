package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class SequenceUpdaterTest {
  @Test
  void update(@Mock AllPlay allPlay, @Mock ChangeThumbnail changeThumbnail) {
    var updater = new SequenceUpdater(allPlay, changeThumbnail);
    var request = new PlaySequencesForUpdate(
      List.of(
        new PlaySequence(
          new ValidRequestForPlay(
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
              .sequence(0L)
              .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
              .time(new PlayTime(1000L, 3000L))
              .channel(new Channel("Music man", "man.png"))
              .build()), 1L),
        new PlaySequence(
          new ValidRequestForPlay(
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
              .id(2L)
              .playlistId(1L)
              .sequence(1L)
              .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
              .time(new PlayTime(2000L, 3000L))
              .channel(new Channel("Music man", "man.png"))
              .build()), 0L)));

    updater.update(request);

    verify(allPlay).updateSequence(1L, 1L);
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
    verify(allPlay).updateSequence(2L, 0L);
    verify(changeThumbnail).changeForUpdateSequence(
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
}