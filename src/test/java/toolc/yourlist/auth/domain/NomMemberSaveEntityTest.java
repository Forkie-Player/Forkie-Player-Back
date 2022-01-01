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
    assertThat(nomMemberSaveEntity.save(new NonMember(1L, "NonMemberUUID")),
      is(new NonMember(1L,"NonMemberUUID")));
  }
}


