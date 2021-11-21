package toolc.yourlist.auth.infra;

import toolc.yourlist.auth.domain.AllMember;
import toolc.yourlist.auth.domain.Member;

public class MemberDomainMapper implements AllMember {

  @Override
  public Member findByLoginId(String loginId) {
    return null;
  }

  @Override
  public Member save(Member member) {
    return null;
  }
}
