package toolc.yourlist.auth.domain;

import toolc.yourlist.member.infra.AllMemberEntity;
import toolc.yourlist.member.infra.MemberEntity;

class MockAllMemberEntity implements AllMemberEntity {

  @Override
  public MemberEntity findByLoginId(String loginId) {
    return new MemberEntity(loginId, "password1!", true);
  }

  @Override
  public MemberEntity save(MemberEntity member) {
    return member;
  }

  public MockAllMemberEntity() {
  }
}
