package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AccessTokenTest {


  @Test
  void equals() {
    assertThat(new AccessToken(), is(new AccessToken()));
  }
}