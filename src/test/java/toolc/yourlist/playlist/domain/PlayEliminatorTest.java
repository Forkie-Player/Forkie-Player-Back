package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayEliminatorTest {
  @Test
  void delete(@Mock AllPlay allPlay, @Mock SequenceUpdater sequenceUpdater, @Mock ChangeThumbnail changeThumbnail) {
    var eliminator = new PlayEliminator(allPlay, sequenceUpdater, changeThumbnail);
    var request = new ValidRequestForPlay(
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
        .build()
    );

    when(allPlay.readAllBelongsTo(1L)).thenReturn(new Plays(
        List.of(
          Play.builder()
            .id(1L)
            .playlistId(1L)
            .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
            .sequence(0L)
            .time(new PlayTime(1000L, 3000L))
            .channel(new Channel("Music man", "mike.png"))
            .build(),
          Play.builder()
            .id(2L)
            .playlistId(1L)
            .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
            .sequence(1L)
            .time(new PlayTime(1500L, 20000L))
            .channel(new Channel("Music man", "mike.png"))
            .build())));

    eliminator.delete(request);
    verify(sequenceUpdater, times(1)).updateWithDelete(new Plays(
      List.of(
        Play.builder()
          .id(1L)
          .playlistId(1L)
          .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
          .sequence(0L)
          .time(new PlayTime(1000L, 3000L))
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
    verify(changeThumbnail, times(1)).changeForEmptyPlaylist(1L);
    verifyNoMoreInteractions(allPlay);
    verifyNoMoreInteractions(sequenceUpdater);
    verifyNoMoreInteractions(changeThumbnail);
  }
}
