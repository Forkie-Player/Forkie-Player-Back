package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistUpdaterTest {
  class MockAllPlaylists implements AllPlaylists {
    @Override
    public ListOfPlaylists readAllBelongsTo(Long memberId) {
      return null;
    }

    @Override
    public Optional<Playlist> readBelongsTo(Long id) {
      return Optional.of(Playlist.builder()
        .id(id)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build());
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 0;
    }

    @Override
    public void save(Playlist playlist) {
    }

    @Override
    public void updateTitleBelongsTo(Long playlistId, String title) {
    }
  }

  @Test
  void updateTitle() {
    var allPlaylists = new MockAllPlaylists();
    var updater = new PlaylistUpdater(allPlaylists);
    var request = new UpdateRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build(),
      Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      "New List");

    var actual = updater.updateTitle(request).get();

    assertThat(actual, is(true));
  }


  @Test
  void updateTitle_not_equal_owner() {
    var allPlaylists = new MockAllPlaylists();
    var updater = new PlaylistUpdater(allPlaylists);
    var request = new UpdateRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build(),
      Playlist.builder()
        .id(1L)
        .memberId(2L)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      "New List");

    var actual = updater.updateTitle(request).getLeft();

    assertThat(actual, is("Playlist 소유자의 요청이 아닙니다."));
  }
}