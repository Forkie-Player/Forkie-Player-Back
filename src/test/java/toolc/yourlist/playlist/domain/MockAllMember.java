package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

import java.util.Optional;

class MockAllMember implements AllMember {

  @Override
  public Optional<Member> findByLoginId(String loginId) {
    return Optional.empty();
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.of(Member.builder()
      .id(id)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build());
  }

  @Override
  public MemberEntity save(MemberEntity memberEntity) {
    return null;
  }
}
