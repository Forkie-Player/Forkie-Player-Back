package toolc.yourlist.auth.infra;

import toolc.yourlist.auth.domain.NonMember;
import toolc.yourlist.member.infra.MemberEntity;

class NonMemberAdapter {
  NonMember toDomainNonMember(MemberEntity member) {
    return new NonMember(member.loginId());
  }
}
