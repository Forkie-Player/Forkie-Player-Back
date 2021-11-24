package toolc.yourlist.member.domain;

import toolc.yourlist.member.infra.Member;
import toolc.yourlist.member.infra.MemberEntity;

public interface AllMember {
  Member findByLoginId(String loginId);
  MemberEntity save(MemberEntity memberEntity);
}
