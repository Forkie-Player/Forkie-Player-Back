package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.member.domain.MemberRepository;

import java.util.Optional;

public interface JpaAllMember extends JpaRepository<MemberEntity, Long>, MemberRepository {
  Optional<MemberEntity> findByLoginId(String loginId);
  Optional<MemberEntity> findById(Long id);
}
