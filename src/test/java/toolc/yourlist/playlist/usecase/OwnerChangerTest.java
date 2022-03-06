package toolc.yourlist.playlist.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.PlaylistOwnerChange;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.User;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static toolc.yourlist.member.domain.UserType.MEMBER;
import static toolc.yourlist.member.domain.UserType.VISITOR;

@ExtendWith(MockitoExtension.class)
class OwnerChangerTest {
  @Test
  void changeOwner(@Mock AllPlaylists allPlaylists) {
    PlaylistOwnerChange changer = new OwnerChanger(allPlaylists);

    changer.changeOwner(1L, 1L);

    verify(allPlaylists).changeOwnerToMember(new User(VISITOR, 1L), new User(MEMBER, 1L));
    verifyNoMoreInteractions(allPlaylists);
  }
}