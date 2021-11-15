package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.All;
import toolc.yourlist.auth.domain.LoginId;
import toolc.yourlist.auth.domain.LoginIdFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LoginIdFactoryTest {

  @Test
  void create_loginId(){
    LoginIdFactory loginIdFactory = new LoginIdFactory(new All());

    assertThat(loginIdFactory.create("loginid"), is(new LoginId("loginid")));
  }

  @Test
  void wrong_loginId(){
    LoginIdFactory loginIdFactory = new LoginIdFactory(new All());

    assertThrows(IllegalArgumentException.class, () ->loginIdFactory.create("Id"));
  }

}