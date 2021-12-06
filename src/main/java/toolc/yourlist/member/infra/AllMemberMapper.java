package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.common.domain.ContractViolationException;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

@RequiredArgsConstructor
@Component
public class AllMemberMapper implements AllMember {

  private final JpaAllMember jpaAllMember;
  private final MemberEntityMapper mapper = new MemberEntityMapper();

  @Override
  public Member findByLoginId(String loginId) {
    var memberEntity = jpaAllMember.findByLoginId(loginId);

    return mapper.toMember(getEntityByLoginId(loginId));
  }

  private MemberEntity getEntityByLoginId(String loginId) {
    return jpaAllMember.findByLoginId(loginId)
      .orElseThrow(
        () -> new ContractViolationException("해당 회원이 존재하지 않습니다."));
  }

  @Override
  public Member findById(Long id) {
    return mapper.toMember(getEntityById(id));
  }

  private MemberEntity getEntityById(Long id) {
    return jpaAllMember.findById(id)
      .orElseThrow(
        () -> new ContractViolationException("해당 회원이 존재하지 않습니다."));
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return jpaAllMember.save(memberEntity);
  }
}
