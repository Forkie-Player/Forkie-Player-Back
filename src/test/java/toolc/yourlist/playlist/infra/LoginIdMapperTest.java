package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.ReadRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LoginIdMapperTest {
  class MockAllMember implements AllMember {

    @Override
    public Member findByLoginId(String loginId) {
      return new Member(1L, "oh980225", true, "qwer1234!");
    }

    @Override
    public Member findById(Long id) {
      return null;
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
      return null;
    }
  }

  @Test
  void toReadRequest() {
    LoginIdMapper mapper = new LoginIdMapper(new MockAllMember());
    var actual = mapper.toReadRequest("oh980225");

    var expected = new ReadRequest("oh980225");
    assertThat(actual.get(), is(expected));
  }
}