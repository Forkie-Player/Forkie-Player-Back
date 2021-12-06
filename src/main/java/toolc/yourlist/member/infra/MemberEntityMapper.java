package toolc.yourlist.member.infra;

import toolc.yourlist.member.domain.Member;

class MemberEntityMapper {
  Member toMember(MemberEntity entity) {
    return Member.builder()
      .id(entity.id())
      .loginId(entity.loginId())
      .isMember(entity.isMember())
      .password(entity.password())
      .build();
  }
}
