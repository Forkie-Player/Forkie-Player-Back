package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualOwnerFactory {
  private final EqualOwnerCondition condition = new EqualOwnerCondition();
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public EqualOwner create(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    condition.check(member, playlist);

    return new EqualOwner(member, playlist);
  }
}
