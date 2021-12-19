package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistCreatorTest {
  class MockAllPlaylists implements AllPlaylists {

    @Override
    public ListOfPlaylists readAllBelongsTo(Long memberId) {
      return null;
    }

    @Override
    public Optional<Playlist> readBelongsTo(Long id) {
      return Optional.empty();
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 5;
    }

    @Override
    public void save(Playlist playlist) {
    }

    @Override
    public void updateTitleBelongsTo(Long playlistId, String title) {
    }
  }

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