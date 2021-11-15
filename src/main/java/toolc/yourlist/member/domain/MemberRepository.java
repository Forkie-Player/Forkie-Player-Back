package toolc.yourlist.member.domain;

import java.util.Optional;

public interface MemberRepository {
  Member findByLoginId(String loginId);
  Optional<Member> findById(Long id);
}
