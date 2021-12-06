package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.infra.NomMemberSaveEntity;
import toolc.yourlist.member.infra.AllMemberEntity;
import toolc.yourlist.member.infra.MemberEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NomMemberSaveEntityTest {

  NomMemberSaveEntity nomMemberSaveEntity;

  @BeforeEach
  void setUp() {
    nomMemberSaveEntity = new NomMemberSaveEntity(new MockAllMemberEntity(),
      new MockPasswordEncoder());
  }

  @Test
  void save_non_member() {
    assertThat(nomMemberSaveEntity.save(new NonMember("NonMemberUUID")),
      is(new NonMember("NonMemberUUID")));
  }
}


class MockAllMemberEntity implements AllMemberEntity {

  @Override
  public MemberEntity findByLoginId(String loginId) {
    return new MemberEntity(loginId, "password1!", true);
  }

  @Override
  public MemberEntity save(MemberEntity member) {
    return member;
  }

  public MockAllMemberEntity() {
  }
}

class MockPasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(String raw) {
    return "encoded" + raw;
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return false;
  }

  public MockPasswordEncoder() {
  }
}