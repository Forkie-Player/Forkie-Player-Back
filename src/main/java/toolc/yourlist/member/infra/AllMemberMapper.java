package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

@RequiredArgsConstructor
@Component
public class AllMemberMapper implements AllMember {

  private final JpaAllMember jpaAllMember;

  @Override
  public Member findByLoginId(String loginId) {
    var memberEntity = jpaAllMember.findByLoginId(loginId);

    if (memberEntity == null) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }

    return memberEntity.toMember();
  }

  @Override
  public Member findById(Long id) {
    return jpaAllMember
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."))
      .toMember();
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return jpaAllMember.save(memberEntity);
  }
}
