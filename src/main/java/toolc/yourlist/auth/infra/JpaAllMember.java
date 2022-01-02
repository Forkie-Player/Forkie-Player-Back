package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AllMember;
import toolc.yourlist.auth.domain.Member;
import toolc.yourlist.member.infra.JpaAllMemberEntity;

@RequiredArgsConstructor
public class JpaAllMember implements AllMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final MemberDomainAdapter adapter;

  @Override
  public Member findByLoginId(String loginId) {
    return adapter.toDomainMember(
      jpaAllMemberEntity.findByLoginId(loginId));
  }

}
