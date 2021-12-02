package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.PlaylistCountCondition;

@RequiredArgsConstructor
final class CountPolicyForNonMember {
  private final PlaylistCountCondition playlistCountCondition = new PlaylistCountCondition();
  private final ReadPersisting readPersisting;

  boolean check(Long memberId) {
    var count = readPersisting.havingCountOf(memberId);
    return playlistCountCondition.check(count);
  }
}
