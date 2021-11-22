package toolc.yourlist.member.domain;

import toolc.yourlist.member.infra.MemberEntity;

import java.util.Optional;

public interface MemberRepository {
  MemberEntity findByLoginId(String loginId);
  Optional<MemberEntity> findById(Long id);
}
