package toolc.yourlist.playlist.domain;

import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

class MockAllMember implements AllMember {

  @Override
  public Member findByLoginId(String loginId) {
    return Member.builder()
      .id(1L)
      .loginId(loginId)
      .password("qwer1234!")
      .isMember(true)
      .build();
  }

  @Override
  public Member findById(Long id) {
    return Member.builder()
      .id(id)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build();
  }

  @Override
  public boolean exist(Long id) {
    return true;
  }
}
