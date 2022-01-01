package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AllMember;
import toolc.yourlist.auth.domain.Member;
import toolc.yourlist.member.infra.JpaAllMemberEntity;
import toolc.yourlist.member.infra.MemberEntity;

@RequiredArgsConstructor
public class JpaAllMember implements AllMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final MemberDomainAdapter adapter;

  @Override
  public Member findByLoginId(String loginId) {
    return adapter.toDomainMember(
      jpaAllMemberEntity.findByLoginId(loginId));
  }

  @Override
  public Member memberSave(Member member) {
    jpaAllMemberEntity.save(new MemberEntity(member.loginId(),
      member.password(), false));
    return member;
  }
}
