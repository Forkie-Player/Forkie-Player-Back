package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LoginRequestTest {

  @Test
  void 유효한_LoginId가_저장되었는가() {
    LoginId loginId = new LoginId("loginId");

    assertThat(loginId.id(), is("loginId"));
  }

}