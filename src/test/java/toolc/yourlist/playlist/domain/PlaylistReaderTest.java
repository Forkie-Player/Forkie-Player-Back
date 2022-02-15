package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaylistReaderTest {
  @Test
  void belongsTo(@Mock AllMember allMember, @Mock AllPlaylists allPlaylists) {
    var reader = new PlaylistReader(allMember, allPlaylists);
    when(allMember.findById(1L)).thenReturn(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234")
        .isMember(true)
        .build());

    reader.belongsTo(1L);

    verify(allMember, times(1)).findById(1L);
    verify(allPlaylists, times(1)).readAllBelongsTo(1L);
    verifyNoMoreInteractions(allMember);
    verifyNoMoreInteractions(allPlaylists);
  }
}