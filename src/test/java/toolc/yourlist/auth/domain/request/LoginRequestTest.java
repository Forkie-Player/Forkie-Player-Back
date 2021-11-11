package toolc.yourlist.auth.domain.request;

import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginRequestTest {

  @Test
  void 유효한_LoginId가_저장되었는가() {
    LoginId loginId1 = new LoginId("testloginid1");
    LoginId loginId2 = new LoginId("testloginid2");

    assertThat(loginId1.raw(), is("testloginid1"));
    assertThat(loginId2.raw(), is("testloginid2"));
  }

  @Test
  void 유효한_Password가_저장되었는가() {
    Password Password1 = new Password("TestPassword1!");
    Password Password2 = new Password("TestPassword2!");

    assertThat(Password1.raw(), is("TestPassword1!"));
    assertThat(Password2.raw(), is("TestPassword2!"));
  }

  @Test
  void LoginId가_올바른_문자들로만_구성되어있는가() {
    LoginId loginId1 = new LoginId("testloginid1");

    assertThat(loginId1.raw(), is("testloginid1"));

    assertThrows(NotValidatedLoginRequestException.class,
                 () -> new LoginId("Tes#@!"));
  }

  @Test
  void Password가_올바른_문자들로만_구성되어있는가() {
    Password password = new Password("testPassword1!");

    assertThat(password.raw(), is("testPassword1!"));
    assertThrows(NotValidatedLoginRequestException.class, () -> new Password("Test"));
    assertThrows(NotValidatedLoginRequestException.class, () -> new Password("TestPassword"));
    assertThrows(NotValidatedLoginRequestException.class, () -> new Password("TestPassword1"));
    assertThrows(NotValidatedLoginRequestException.class, () -> new Password("TestPassword!"));
  }
}