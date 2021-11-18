package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NomMemberSaveEntityTest {

  NomMemberSaveEntity nomMemberSaveEntity;

  @BeforeEach
  void setUp() {
    nomMemberSaveEntity = new NomMemberSaveEntity(new MockAllMember(), new MockPasswordEncoder());
  }

  @Test
  void save_non_member() {
    assertThat(nomMemberSaveEntity.save(new NonMember("NonMemberUUID")),
      is(new NonMember("NonMemberUUID")));
  }
}


class MockAllMember implements AllMember {

  @Override
  public Member findByLoginId(String loginId) {
    return new Member(loginId, "password1!", true);
  }

  @Override
  public Member save(Member member) {
    return member;
  }

  public MockAllMember() {
  }
}

class MockPasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(String raw) {
    return "encoded" + raw;
  }

  public MockPasswordEncoder() {
  }
}