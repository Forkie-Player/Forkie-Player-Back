package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.AllPasswordPolicy;
import toolc.yourlist.auth.domain.Password;
import toolc.yourlist.auth.domain.PasswordFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordFactoryTest {
  @Test
  void create_Password() {
    PasswordFactory passwordFactory = new PasswordFactory(new AllPasswordPolicy());

    assertThat(passwordFactory.create("password!"), is(new Password("password!")));
  }

  @Test
  void wrong_Password() {
    PasswordFactory passwordFactory = new PasswordFactory(new AllPasswordPolicy());

    assertThrows(IllegalArgumentException.class, () -> passwordFactory.create("Id"));
  }
}