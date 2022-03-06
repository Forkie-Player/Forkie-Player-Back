package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.UserType;

final class RealMemberCondition {
  boolean check(User user) {
    return user.userType() == UserType.MEMBER;
  }
}
