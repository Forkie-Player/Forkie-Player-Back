package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CountLimitTest {
  SavePolicy countLimit = new CountLimit();

  @Test
  void 갯수_5개이상() {
    assertThat(countLimit.matches(
      SaveRequest.builder()
        .playlistCount(5)
        .build()), is(false));
  }

  @Test
  void 갯수_5개미만() {
    assertThat(countLimit.matches(
      SaveRequest.builder()
        .playlistCount(4)
        .build()), is(true));
  }
}