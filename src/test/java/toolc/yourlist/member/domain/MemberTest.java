package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MemberTest {

  @Test
  void equals() {
    LoginId loginId = new LoginId("jisoo27");
    Password password = new Password("Wltn1227!");

    Member member = new Member(loginId, password);

    assertThat(member, is(new Member(loginId, password)));
  }
}