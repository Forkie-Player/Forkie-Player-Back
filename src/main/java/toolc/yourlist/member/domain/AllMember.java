package toolc.yourlist.member.domain;

import toolc.yourlist.member.infra.MemberEntity;

import java.util.Optional;

public interface AllMember {
  Optional<Member> findByLoginId(String loginId);
  Optional<Member> findById(Long id);
  MemberEntity save(MemberEntity memberEntity);
}
