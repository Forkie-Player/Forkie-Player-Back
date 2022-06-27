package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.UserType;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaylistReaderTest {
  @Test
  void belongsTo(@Mock AllPlaylists allPlaylists, @Mock AllPlay allPlay) {
    var reader = new PlaylistReader(allPlaylists, allPlay);
    var user = new User(UserType.MEMBER, 1L);
    given(allPlaylists.readAllBelongsTo(user)).willReturn(new Playlists(
      List.of(
        new Playlist(1L, "MEMBER_1", "games", "panda.png")
      )
    ));

    reader.belongsTo(user);

    verify(allPlaylists, times(1)).readAllBelongsTo(user);
    verify(allPlay, times(1)).havingCountOf(anyLong());
    verifyNoMoreInteractions(allPlaylists);
  }
}