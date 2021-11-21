package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.Member;
import toolc.yourlist.member.domain.MemberEntity;

@RequiredArgsConstructor
public class MemberDomainAdapter {

  Member toDomainMember(MemberEntity member) {
    return new Member(member.loginId(), member.password());
  }
}
