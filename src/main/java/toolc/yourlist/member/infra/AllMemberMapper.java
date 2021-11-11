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
    return jpaAllMember.findByLoginId(loginId);
  }

  @Override
  public Member save(Member member) {
    return jpaAllMember.save(member);
  }
}
