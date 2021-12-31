package toolc.yourlist.member.infra;

import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.NoExistMemberException;

import java.util.Optional;

class MemberEntityMapper {
  Member toMember(MemberEntity entity) {
    if (entity == null) {
      throw new NoExistMemberException();
    }

    return Member.builder()
      .id(entity.id())
      .loginId(entity.loginId())
      .isMember(entity.isMember())
      .password(entity.password())
      .build();
  }

  Member toMember(Optional<MemberEntity> entity) {
    if (entity.isEmpty()) {
      throw new NoExistMemberException();
    }

    return Member.builder()
      .id(entity.get().id())
      .loginId(entity.get().loginId())
      .isMember(entity.get().isMember())
      .password(entity.get().password())
      .build();
  }
}
