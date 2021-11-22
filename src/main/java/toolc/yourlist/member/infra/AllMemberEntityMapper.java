package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AllMemberEntityMapper implements AllMemberEntity {

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
