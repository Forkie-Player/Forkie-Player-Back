package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AllMemberMapper implements AllMember {

  private final JpaAllMember jpaAllMember;
  private final MemberEntityMapper mapper = new MemberEntityMapper();

  @Override
  public Optional<Member> findByLoginId(String loginId) {
    var memberEntity = jpaAllMember.findByLoginId(loginId);

    return mapper.toMember(jpaAllMember.findByLoginId(loginId));
  }

  @Override
  public Optional<Member> findById(Long id) {
    return mapper.toMember(jpaAllMember.findById(id));
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return jpaAllMember.save(memberEntity);
  }
}
