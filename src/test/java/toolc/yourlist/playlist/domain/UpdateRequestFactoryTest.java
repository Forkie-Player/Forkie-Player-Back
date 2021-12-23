package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UpdateRequestFactoryTest {

  @Test
  void create() {
    var allMember = new MockAllMember();
    var allPlaylists = new MockAllPlaylists();
    var factory = new UpdateRequestFactory(allMember, allPlaylists);

    var actual =
      factory.create(1L, 1L, "New List").get();

    var expected = new UpdateRequest(Member.builder()
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
    assertThat(actual, is(expected));
  }

  @Test
  void creat_not_exist_member() {
    var allMember = new EmptyMember();
    var allPlaylists = new MockAllPlaylists();
    var factory = new UpdateRequestFactory(allMember, allPlaylists);

    var actual =
      factory.create(1L, 1L, "New List").getLeft();

    assertThat(actual, is("존재하지 않는 회원"));
  }

  @Test
  void creat_not_exist_playlist() {
    var allMember = new MockAllMember();
    var allPlaylists = new EmptyPlaylist();
    var factory = new UpdateRequestFactory(allMember, allPlaylists);

    var actual =
      factory.create(1L, 1L, "New List").getLeft();

    assertThat(actual, is("존재하지 않는 영상 목록"));
  }
}