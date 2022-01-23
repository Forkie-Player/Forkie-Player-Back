package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualOwnerFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public EqualOwner create(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new EqualOwner(member, playlist);
  }
}
