package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.playlist.domain.*;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaylistThumbnailTest {
  @Test
  void changeForMakingFirstPlay(@Mock AllPlaylists allPlaylists, @Mock AllPlay allPlay) {
    var changer = new PlaylistThumbnail(allPlaylists, allPlay);
    when(allPlay.havingCountOf(any())).thenReturn(1L);

    changer.changeForMakingFirstPlay(1L, "puppy.png");

    verify(allPlaylists, times(1)).updateThumbnail(1L, "puppy.png");
    verifyNoMoreInteractions(allPlaylists);
  }

  @Test
  void changeForUpdateSequence(@Mock AllPlaylists allPlaylists, @Mock AllPlay allPlay) {
    var changer = new PlaylistThumbnail(allPlaylists, allPlay);

    changer.changeForUpdateSequence(
      Play.builder()
        .id(1L)
        .playlistId(1L)
        .sequence(3L)
        .info(new PlayInfo("So Good Music", "abcd1234", "puppy.png"))
        .channel(new Channel("smileMan", "smile.png"))
        .time(new PlayTime(2000L, 3000L))
        .build(), 0L);

    verify(allPlaylists, times(1)).updateThumbnail(1L, "puppy.png");
    verifyNoMoreInteractions(allPlaylists);
  }

  @Test
  void changeForDelete(@Mock AllPlaylists allPlaylists, @Mock AllPlay allPlay) {
    var changer = new PlaylistThumbnail(allPlaylists, allPlay);
    when(allPlay.havingCountOf(any())).thenReturn(1L);

    changer.changeForEmptyPlaylist(1L);

    verify(allPlaylists, times(1)).updateThumbnail(1L, null);
    verifyNoMoreInteractions(allPlaylists);
  }
}