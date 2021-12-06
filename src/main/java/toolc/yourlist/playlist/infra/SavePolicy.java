package toolc.yourlist.playlist.infra;

import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.PlaylistCountCondition;
import toolc.yourlist.playlist.domain.RealMemberCondition;

final class SavePolicy {
  private final PlaylistCountCondition countCondition = new PlaylistCountCondition();
  private final RealMemberCondition realMemberCondition = new RealMemberCondition();

  boolean match(Member member, Long count) {
    return countCondition.check(count) ||
      realMemberCondition.check(member);
  }
}
