package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.member.domain.Member;

public interface JpaAllMember extends JpaRepository<Member, Long> {

  Member findByLoginId(String loginId);
}
