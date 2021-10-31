package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LoginRequestTest {

  @Test
  void 유효한_LoginId가_저장되었는가() {
    LoginRequest.LoginId loginId1 = new LoginRequest.LoginId("TestLoginId1");
    LoginRequest.LoginId loginId2 = new LoginRequest.LoginId("TestLoginId2");

    assertThat(loginId1.id(), is("TestLoginId1"));
    assertThat(loginId2.id(), is("TestLoginId2"));
  }



}