package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NonMemberTest {

  @Test
  void equals() {
    assertThat(new NonMember(100L,"55D154BE-07E6-42FA-832B-D9CF11CE0D6A"),
      is(new NonMember(100L,"55D154BE-07E6-42FA-832B-D9CF11CE0D6A")));
  }

  @Test
  void non_null() {
    assertThrows(IllegalArgumentException.class, () ->
      new NonMember(100L,null));
  }

  @Test
  void non_empty() {
    assertThrows(IllegalArgumentException.class, () ->
      new NonMember(100L,""));
  }
}