package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaAllMemberEntity extends JpaRepository<MemberEntity, Long> {
  Optional<MemberEntity> findByLoginId(String loginId);

  Optional<MemberEntity> findByLoginIdAndProvider(String loginId, Provider provider);

  Optional<MemberEntity> findById(Long id);

  MemberEntity save(MemberEntity memberEntity);

  @Query("select count(m) from MemberEntity m where m.nickname like :nickname%")
  long countContainNickname(@Param("nickname") String nickname);
}
