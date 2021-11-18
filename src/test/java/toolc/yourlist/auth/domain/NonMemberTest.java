package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NonMemberTest {

  @Test
  void equals() {
    assertThat(new NonMember("UUID_abcdefghijkl"), is(new NonMember("UUID_abcdefghijkl")));
  }

  @Test
  void non_null() {
    assertThrows(IllegalArgumentException.class, () ->
      new NonMember(null));
  }

  @Test
  void non_empty() {
    assertThrows(IllegalArgumentException.class, () ->
      new NonMember(""));
  }
}