package toolc.yourlist.playlist.infra;

import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.Member;
import toolc.yourlist.playlist.domain.NoExistMemberException;

import java.util.Optional;

class MemberEntityMapper {
  Member toMember(MemberEntity entity) {
    if (entity == null) {
      throw new NoExistMemberException();
    }

    return Member.builder()
      .id(entity.id())
      .loginId(entity.loginId())
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
      .password(entity.get().password())
      .build();
  }
}
