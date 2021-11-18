package toolc.yourlist.play.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static toolc.yourlist.play.domain.PlaylistSaveRequestFixture.playlistSaveRequest;

class RealMemberTest {
  SavePolicy realMember = new RealMember();

  @Test
  void 회원() {
    assertThat(realMember.matches(playlistSaveRequest()
      .isMember(true)
      .build()), is(true));
  }

  @Test
  void 비회원() {
    assertThat(realMember.matches(playlistSaveRequest()
      .isMember(false)
      .build()), is(false));
  }
}