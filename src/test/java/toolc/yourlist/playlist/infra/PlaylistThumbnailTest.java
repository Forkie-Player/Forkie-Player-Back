package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.playlist.domain.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PlaylistThumbnailTest {
  @Test
  void changeForMakingFirstPlay(@Mock AllPlaylists allPlaylists) {
    var changer = new PlaylistThumbnail(allPlaylists);

    changer.changeForMakingFirstPlay(1L, "puppy.png", 0L);

    verify(allPlaylists).updateThumbnail(1L, "puppy.png");
    verifyNoMoreInteractions(allPlaylists);
  }

  @Test
  void changeForUpdateSequence(@Mock AllPlaylists allPlaylists) {
    var changer = new PlaylistThumbnail(allPlaylists);

    changer.changeForUpdateSequence(
      Play.builder()
        .id(1L)
        .playlistId(1L)
        .sequence(3L)
        .info(new PlayInfo("So Good Music", "abcd1234", "puppy.png"))
        .channel(new Channel("smileMan", "smile.png"))
        .time(new PlayTime(2000L, 3000L))
        .build(), 1L);

    verify(allPlaylists).updateThumbnail(1L, "puppy.png");
    verifyNoMoreInteractions(allPlaylists);
  }
}