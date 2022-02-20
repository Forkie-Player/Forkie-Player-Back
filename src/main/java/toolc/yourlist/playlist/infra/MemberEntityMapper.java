package toolc.yourlist.playlist.infra;

import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.Member;
import toolc.yourlist.playlist.domain.exception.NoExistMemberException;

import java.util.Optional;

class MemberEntityMapper {
  Member toMember(MemberEntity entity) {
    return Member.builder()
      .id(entity.id())
      .loginId(entity.loginId())
      .password(entity.password())
      .build();
  }
}
