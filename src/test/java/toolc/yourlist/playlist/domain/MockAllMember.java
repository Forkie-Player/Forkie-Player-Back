package toolc.yourlist.playlist.domain;

class MockAllMember implements AllMember {
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
