package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.MemberRepository;

import java.util.Optional;

public interface JpaAllMember extends JpaRepository<Member, Long>, MemberRepository {
  Member findByLoginId(String loginId);
}
