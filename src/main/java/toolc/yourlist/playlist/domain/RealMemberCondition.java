package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.Member;

public final class RealMemberCondition {
  public boolean check(Member member) {
    return member.isMember();
  }
}
