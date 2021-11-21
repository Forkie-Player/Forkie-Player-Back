package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.MemberEntity;

@RequiredArgsConstructor
@Component
public class AllMemberMapper implements AllMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;

  @Override
  public MemberEntity findByLoginId(String loginId) {
    return jpaAllMemberEntity.findByLoginId(loginId);
  }

  @Override
  public MemberEntity save(MemberEntity member) {
    return jpaAllMemberEntity.save(member);
  }
}
