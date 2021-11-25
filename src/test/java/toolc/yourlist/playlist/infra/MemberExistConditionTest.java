package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.member.infra.MemberEntity;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MemberExistConditionTest {
  @Test
  void 회원_존재() {
    MemberExistCondition memberExistCondition = new MemberExistCondition(MockAllMember.builder()
      .findByLoginId(loginId -> new Member(
        new MemberEntity(loginId, "qwer1234!", true)
      ))
      .build());

    var actual = memberExistCondition.check("oh980225");

    var expected = new Member(
      new MemberEntity("oh980225", "qwer1234!", true)
    );
    assertThat(actual.get(), is(expected));
  }

  @Test
  void 회원_존재X() {
    MemberExistCondition memberExistCondition = new MemberExistCondition(MockAllMember.builder()
      .findByLoginId(loginId -> new Member(Optional.empty()))
      .build());

    var actual = memberExistCondition.check("oh980225");

    assertThat(actual.getLeft(), is("존재하지 않는 회원입니다."));
  }
}