package toolc.yourlist.playlist.domain;

final class RealMemberCondition {
  boolean check(Member member) {
    return member.isMember();
  }
}
