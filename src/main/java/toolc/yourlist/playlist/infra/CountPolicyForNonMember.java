package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.PlaylistCountCondition;

@RequiredArgsConstructor
final class CountPolicyForNonMember implements PlaylistCountCondition {

  @Override
  public boolean check(long havingCount) {
    return havingCount < 5;
  }
}
