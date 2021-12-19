package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.Member;

final class SavePolicy {
  private final PlaylistCountCondition countCondition = new PlaylistCountCondition();
  private final RealMemberCondition realMemberCondition = new RealMemberCondition();

  boolean match(Member member, Long count) {
    return countCondition.check(count) ||
      realMemberCondition.check(member);
  }
}
