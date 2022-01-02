package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NonMemberSignUpRequestTest {

  @Test
  void equals() {
    var nonMemberSignUpRequest = new NonMemberSignUpRequest("55D154BE-07E6-42FA-832B-D9CF11CE0D6A");

    assertThat(nonMemberSignUpRequest, is(
      new NonMemberSignUpRequest("55D154BE-07E6-42FA-832B-D9CF11CE0D6A")));
  }

}