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
class PlaylistEliminatorTest {
  @Test
  void delete(@Mock AllPlaylists allPlaylists) {
    var eliminator = new PlaylistEliminator(allPlaylists);
    var request = new DeleteRequest(
      new ValidRequestForPlaylist(
        new User(MEMBER, 1L),
        Playlist.builder()
          .id(1L)
          .userCode("MEMBER_1")
          .title("My List")
          .thumbnail("panda.png")
          .build()));

    eliminator.delete(request);

    verify(allPlaylists).delete(request.validRequestForPlaylist().get());
    verifyNoMoreInteractions(allPlaylists);
  }
}