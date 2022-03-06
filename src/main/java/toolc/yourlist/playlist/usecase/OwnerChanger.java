package toolc.yourlist.playlist.usecase;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.PlaylistOwnerChange;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.User;

import static toolc.yourlist.member.domain.UserType.MEMBER;
import static toolc.yourlist.member.domain.UserType.VISITOR;

@RequiredArgsConstructor
public class OwnerChanger implements PlaylistOwnerChange {
  private final AllPlaylists allPlaylists;

  @Override
  public void changeOwner(Long oldId, Long newID) {
    var visitor = new User(VISITOR, oldId);
    var member = new User(MEMBER, newID);

    allPlaylists.changeOwnerToMember(visitor, member);
  }
}
