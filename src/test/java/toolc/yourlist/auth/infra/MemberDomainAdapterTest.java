package toolc.yourlist.auth.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MemberDomainAdapterTest {

  @Test
  void adapter() {
    MemberDomainAdapter adapter = new MemberDomainAdapter();
    MemberEntity memberEntity = new MemberEntity("jspark27", "encodedPassword"
      , false);

    Member actual = adapter.toDomainMember(memberEntity);
    System.out.println(actual.id());

    assertThat(new Member(null, "jspark27", "encodedPassword"), is(actual));

  }

}