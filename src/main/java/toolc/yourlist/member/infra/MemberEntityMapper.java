package toolc.yourlist.member.infra;

import toolc.yourlist.member.domain.Member;

import java.util.Optional;

class MemberEntityMapper {
  Optional<Member> toMember(Optional<MemberEntity> entity) {
    if (entity.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(Member.builder()
      .id(entity.get().id())
      .loginId(entity.get().loginId())
      .isMember(entity.get().isMember())
      .password(entity.get().password())
      .build());
  }
}
