package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
@Component
public class AllMemberMapper implements AllMember {

  private final JpaAllMember jpaAllMember;

  @Override
  public Member findByLoginId(String loginId) {
    return new Member(jpaAllMember.findByLoginId(loginId));
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return jpaAllMember.save(memberEntity);
  }
}
