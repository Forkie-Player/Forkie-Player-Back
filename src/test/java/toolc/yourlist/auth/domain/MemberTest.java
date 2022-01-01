package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MemberTest {

  @Test
  void equals() {
    assertThat(new Member(1L, "jspark27", "q1w2e3r4!@#"),
      is(new Member(1L, "jspark27", "q1w2e3r4!@#")));
  }

}