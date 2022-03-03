package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.UserType;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaylistReaderTest {
  @Test
  void belongsTo(@Mock AllPlaylists allPlaylists) {
    var reader = new PlaylistReader(allPlaylists);
    var user = new User(UserType.MEMBER, 1L);

    reader.belongsTo(user);

    verify(allPlaylists, times(1)).readAllBelongsTo(user);
    verifyNoMoreInteractions(allPlaylists);
  }
}