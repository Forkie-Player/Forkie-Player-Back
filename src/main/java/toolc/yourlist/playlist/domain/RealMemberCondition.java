package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.Member;

final class RealMemberCondition {
  boolean check(Member member) {
    return member.isMember();
  }
}
