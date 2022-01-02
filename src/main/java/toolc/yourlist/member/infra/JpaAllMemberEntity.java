package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.member.domain.MemberRepository;

public interface JpaAllMemberEntity extends JpaRepository<MemberEntity, Long>, MemberRepository {
  MemberEntity findByLoginId(String loginId);
  MemberEntity save(MemberEntity memberEntity);
}
