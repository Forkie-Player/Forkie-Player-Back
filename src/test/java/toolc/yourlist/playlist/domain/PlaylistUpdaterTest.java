package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static toolc.yourlist.member.domain.UserType.MEMBER;

@ExtendWith(MockitoExtension.class)
class PlaylistUpdaterTest {
  @Test
  void updateTitle(@Mock AllPlaylists allPlaylists) {
    var updater = new PlaylistUpdater(allPlaylists);
    var request = new UpdateRequest(
      new ValidRequestForPlaylist(
        new User(MEMBER, 1L),
        Playlist.builder()
          .id(1L)
          .userCode("MEMBER_1")
          .title("My List")
          .thumbnail("panda.png")
          .build()),
      "My Music");

    updater.updateTitle(request);

    verify(allPlaylists).updateTitleBelongsTo(
      request.validRequestForPlaylist().get().id(),
      request.title());
    verifyNoMoreInteractions(allPlaylists);
  }
}