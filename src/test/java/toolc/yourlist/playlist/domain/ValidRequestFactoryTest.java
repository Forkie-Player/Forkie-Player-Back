package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.UserType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ValidRequestFactoryTest {
  @Test
  void createForPlaylist() {
    var factory = new ValidRequestFactory(new MockAllPlaylists(), new MockAllPlay());

    var actual = factory.createForPlaylist(new User(UserType.MEMBER, 1L), 1L);

    var expected = new ValidRequestForPlaylist(
      new User(UserType.MEMBER, 1L),
      Playlist.builder()
        .id(1L)
        .userCode("MEMBER_1")
        .title("My List")
        .thumbnail("panda.png")
        .build()
    );
    assertThat(actual, is(expected));
  }

  @Test
  void createForPlay() {
    var factory = new ValidRequestFactory(new MockAllPlaylists(), new MockAllPlay());

    var actual = factory.createForPlay(new User(UserType.MEMBER, 1L), 1L, 1L);

    var expected = new ValidRequestForPlay(
      new User(UserType.MEMBER, 1L),
      Playlist.builder()
        .id(1L)
        .userCode("MEMBER_1")
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Play.builder()
        .id(1L)
        .playlistId(1L)
        .sequence(1L)
        .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
        .time(new PlayTime(1000L, 3000L))
        .channel(new Channel("Music man", "man.png"))
        .build()
    );
    assertThat(actual, is(expected));
  }
}