package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

// TODO: Mockito이용해서 오케스트레이션 -> 함수의 콜을 확인하는 테스트 필요
class PlaylistCreatorTest {
  @Test
  void createPlaylist() {
    var allPlaylists = new MockAllPlaylists();
    var allMember = new MockAllMember();
    var creator = new PlaylistCreator(allMember, allPlaylists);
    var request = new SaveRequest(
      1L,
      "My List");

    var actual = creator.create(request).get();

    assertThat(actual, is(true));
  }
}