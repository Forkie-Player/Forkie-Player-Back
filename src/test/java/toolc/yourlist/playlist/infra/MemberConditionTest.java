package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.LoginId2;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MemberConditionTest {
  class MockAllRealMember implements AllMember {
    @Override
    public Member findByLoginId(String loginId) {
      return null;
    }

    @Override
    public Member findById(Long id) {
      return new Member(id, "oh980225", true, "qwer1234!");
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
      return null;
    }
  }

  class MockAllNonMember implements AllMember {
    @Override
    public Member findByLoginId(String loginId) {
      return null;
    }

    @Override
    public Member findById(Long id) {
      return new Member(id, "oh1263", true, "abcd1234!");
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
      return null;
    }
  }


  @Test
  void checkRealMember() {
    var condition = new MemberCondition(new MockAllRealMember());

    var actual = condition.checkRealMember(1L);

    assertThat(actual, is(true));
  }

  @Test
  void checkNonMember() {
    var condition = new MemberCondition(new MockAllNonMember());

    var actual = condition.checkRealMember(1L);

    assertThat(actual, is(true));
  }
}