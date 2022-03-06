package toolc.yourlist.playlist.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.User;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static toolc.yourlist.member.domain.UserType.MEMBER;

@ExtendWith(MockitoExtension.class)
class DefaultPlaylistTest {
  @Test
  void make(@Mock AllPlaylists allPlaylists) {
    var makeDefaultPlaylist = new DefaultPlaylist(allPlaylists);

    makeDefaultPlaylist.make(1L, MEMBER);

    var expectedDefaultPlaylist = Playlist.builder()
      .userCode(new User(MEMBER, 1L).code())
      .title("default")
      .build();
    verify(allPlaylists).save(expectedDefaultPlaylist);
    verifyNoMoreInteractions(allPlaylists);
  }
}