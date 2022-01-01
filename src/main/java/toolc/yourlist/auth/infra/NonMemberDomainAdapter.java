package toolc.yourlist.auth.infra;

import toolc.yourlist.auth.domain.NonMember;
import toolc.yourlist.member.infra.MemberEntity;

class NonMemberDomainAdapter {
  NonMember toDomainNonMember(MemberEntity member) {
    return new NonMember(member.id(), member.loginId());
  }
}
