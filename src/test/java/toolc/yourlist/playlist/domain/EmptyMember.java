package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

import java.util.Optional;

class EmptyMember implements AllMember {

  @Override
  public Optional<Member> findByLoginId(String loginId) {
    return Optional.empty();
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return null;
  }
}
