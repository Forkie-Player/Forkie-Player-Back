package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NonMemberTest {

  @Test
  void equals() {
    assertThat(new NonMember("UUID_abcdefghijkl"), is(new NonMember("UUID_abcdefghijkl")));
  }
}