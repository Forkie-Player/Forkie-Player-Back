package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EqualMemberFactoryTest {

  @Test
  void createForPlaylist() {
    var factory = new EqualMemberFactory(new MockAllMember(), new MockAllPlaylists(), new MockAllPlay());

    var actual = factory.createForPlaylist(1L, 1L);

    var expected = new ValidRequestForPlaylist(
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
        .build()
    );
    assertThat(actual, is(expected));
  }

  @Test
  void createForPlay() {
    var factory = new EqualMemberFactory(new MockAllMember(), new MockAllPlaylists(), new MockAllPlay());

    var actual = factory.createForPlay(1L, 1L);

    var expected = new ValidRequestForPlay(
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