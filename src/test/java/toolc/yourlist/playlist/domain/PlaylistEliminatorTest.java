package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistEliminatorTest {

  @Test
  void delete() {
    var allPlaylists = new MockAllPlaylists();
    var eliminator = new PlaylistEliminator(allPlaylists);
    var request = new DeleteRequest(
      Member.builder()
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
        .build());

    var actual = eliminator.delete(request).get();

    assertThat(actual, is(Boolean.TRUE));
  }

  @Test
  void delete_not_equal_owner() {
    var allPlaylists = new MockAllPlaylists();
    var eliminator = new PlaylistEliminator(allPlaylists);
    var request = new DeleteRequest(
      Member.builder()
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
        .build());

    var actual = eliminator.delete(request).getLeft();

    assertThat(actual, is("Playlist 소유자의 요청이 아닙니다."));
  }
}