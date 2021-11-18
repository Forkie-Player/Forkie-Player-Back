package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static toolc.yourlist.RequestFixture.saveRequest;

class RealMemberTest {
  SavePolicy realMember = new RealMember();

  @Test
  void 회원() {
    assertThat(realMember.matches(saveRequest()
      .isMember(true)
      .build()), is(true));
  }

  @Test
  void 비회원() {
    assertThat(realMember.matches(saveRequest()
      .isMember(false)
      .build()), is(false));
  }
}