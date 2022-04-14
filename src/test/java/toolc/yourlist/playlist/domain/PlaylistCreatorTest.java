package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static toolc.yourlist.member.domain.UserType.MEMBER;

@ExtendWith(MockitoExtension.class)
class PlaylistCreatorTest {
  @Test
  void create(@Mock AllPlaylists allPlaylists) {
    var creator = new PlaylistCreator(allPlaylists);
    var request = new SaveRequest(new User(MEMBER, 1L), "My List");

    creator.create(request);

    verify(allPlaylists).save(Playlist.builder()
      .userCode("MEMBER_1")
      .title("My List")
      .build());
    verifyNoMoreInteractions(allPlaylists);
  }
}