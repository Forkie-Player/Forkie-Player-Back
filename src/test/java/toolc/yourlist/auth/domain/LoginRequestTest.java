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

  @Test
  void 유효한_Password가_저장되었는가() {
    LoginRequest.Password Password1 = new LoginRequest.Password("TestPassword1");
    LoginRequest.Password Password2 = new LoginRequest.Password("TestPassword2");

    assertThat(Password1.password(), is("TestPassword1"));
    assertThat(Password1.password(), is("TestPassword2"));
  }



}