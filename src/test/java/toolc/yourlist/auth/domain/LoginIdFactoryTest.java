package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LoginIdFactoryTest {

  @Test
  void create_loginId() {
    LoginIdFactory loginIdFactory = new LoginIdFactory(new AllLoginPolicy());

    assertThat(loginIdFactory.create("loginid"), is(new LoginId("loginid")));
  }

  @Test
  void wrong_loginId() {
    LoginIdFactory loginIdFactory = new LoginIdFactory(new AllLoginPolicy());

    assertThrows(IllegalArgumentException.class, () -> loginIdFactory.create(
      "Id"));
  }

}