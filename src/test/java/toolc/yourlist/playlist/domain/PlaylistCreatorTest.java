package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistCreatorTest {

  @Test
  void createPlaylist() {
    var allPlaylists = new MockAllPlaylists();
    var creator = new PlaylistCreator(allPlaylists);
    var request = new SaveRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build(),
      "My List");

    var actual = creator.createPlaylist(request).get();

    assertThat(actual, is(true));
  }

  @Test
  void createPlaylist_not_match_save_policy() {
    var allPlaylists = new MockAllPlaylists();
    var creator = new PlaylistCreator(allPlaylists);
    var request = new SaveRequest(Member.builder()
      .id(1L)
      .loginId("oh1263")
      .password("abcd1234!")
      .isMember(false)
      .build(),
      "My List");

    var actual = creator.createPlaylist(request).getLeft();

    assertThat(actual, is("비회원의 영상 생성 제한을 넘었습니다."));
  }
}