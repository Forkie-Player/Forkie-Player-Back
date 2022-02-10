package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PlaylistUpdaterTest {
  @Test
  void updateTitle(@Mock AllPlaylists allPlaylists) {
    var updater = new PlaylistUpdater(allPlaylists);
    var request = new UpdateRequest(
      new ValidRequestForPlaylist(
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
          .build()
      ),
      "My Music");

    updater.updateTitle(request);

    verify(allPlaylists).updateTitleBelongsTo(
      request.validRequestForPlaylist().playlist().id(),
      request.title());
    verifyNoMoreInteractions(allPlaylists);
  }
}