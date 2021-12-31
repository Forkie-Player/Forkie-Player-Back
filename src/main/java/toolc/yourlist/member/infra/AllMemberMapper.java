package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.NoExistMemberException;

@RequiredArgsConstructor
@Component
public class AllMemberMapper implements AllMember {

  private final JpaAllMemberEntity jpaAllMemberEntity;
  private final MemberEntityMapper mapper = new MemberEntityMapper();

  @Override
  public Member findByLoginId(String loginId) {
    var memberEntity = jpaAllMemberEntity.findByLoginId(loginId);

    return mapper.toMember(jpaAllMemberEntity.findByLoginId(loginId));
  }

  @Override
  public Member findById(Long id) {
    return mapper.toMember(jpaAllMemberEntity.findById(id));
  }

  @Override
  public boolean exist(Long id) {
    try {
      findById(id);
      return true;
    } catch (NoExistMemberException e) {
      return false;
    }
  }
}
