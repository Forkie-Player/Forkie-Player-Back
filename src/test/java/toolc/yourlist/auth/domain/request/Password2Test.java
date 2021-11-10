package toolc.yourlist.auth.domain.request;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class Password2Test {

  @Test
  void equals() {
    assertThat(new Password2("password1227!"), is(new Password2("password1227!")));
  }
}