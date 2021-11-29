package toolc.yourlist.member.domain;

import toolc.yourlist.member.infra.MemberEntity;

public interface AllMember {
  Member findByLoginId(String loginId);
  Member findById(Long id);
  MemberEntity save(MemberEntity memberEntity);
}
