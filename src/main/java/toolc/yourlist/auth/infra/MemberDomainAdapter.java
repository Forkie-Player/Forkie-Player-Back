package toolc.yourlist.auth.infra;

import toolc.yourlist.auth.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

public class MemberDomainAdapter {

  Member toDomainMember(MemberEntity member) {
    return new Member(member.loginId(), member.password());
  }
}
