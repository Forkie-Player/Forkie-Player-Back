package toolc.yourlist.auth.domain.request;

import org.junit.jupiter.api.Test;

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