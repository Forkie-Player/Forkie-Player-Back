package toolc.yourlist.auth.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.NonMember;
import toolc.yourlist.member.infra.MemberEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NonMemberAdapterTest {

  @Test
  void make_non_member() {
    //given
    final var adapter = new NonMemberDomainAdapter();
    final var entity = MemberEntity.builder()
      .loginId("55D154BE-07E6-42FA-832B-D9CF11CE0D6A")
      .isMember(false)
      .build();

    //when
    final var actual = adapter.toDomainNonMember(entity);

    //then
    final var expected = new NonMember(null, "55D154BE-07E6-42FA-832B-D9CF11CE0D6A");
    assertThat(actual, is(expected));
  }
}