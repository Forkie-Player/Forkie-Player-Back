package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAllMemberEntity extends JpaRepository<MemberEntity, Long> {
  Optional<MemberEntity> findByLoginId(String loginId);
  Optional<MemberEntity> findByLoginIdAndProvider(String loginId, Provider provider);
  Optional<MemberEntity> findById(Long id);
  MemberEntity save(MemberEntity memberEntity);
}
