package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

@RequiredArgsConstructor
public class AllMemberMapper implements AllMember {

  private final JpaAllMember jpaAllMember;

  @Override
  public Member findByLoginId(String loginId) {
    return jpaAllMember.findByLoginId(loginId);
  }
}
