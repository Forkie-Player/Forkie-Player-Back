package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.request.LoginRequest;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class MemberLoginTest {

  MemberLogin login = new MemberLogin();

  @Test
  void 로그인으로_토큰이_생성되는가() {
    //given
    LoginRequest request = new LoginRequest("testloginid", "TestPassword1!", LoginRequest.Device.PC);

    //when
    Token loginToken = login.login(request);

    //then
    assertThat(loginToken, notNullValue());
  }
}