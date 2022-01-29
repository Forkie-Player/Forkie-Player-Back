package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EqualOwnerFactoryTest {

  @Test
  void createForPlaylist() {
    var factory = new EqualOwnerFactory(new MockAllMember(), new MockAllPlaylists(), new MockAllPlay());

    var actual = factory.createForPlaylist(1L, 1L);

    var expected = new EqualOwnerForPlaylist(
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
  void createForPlaylist_not_equal_owner() {
    var factory = new EqualOwnerFactory(new MockAllMember(), new MockAllPlaylists(), new MockAllPlay());

    assertThrows(NotOwnerException.class, () -> factory.createForPlaylist(2L, 1L));
  }

  @Test
  void createForPlay() {
    var factory = new EqualOwnerFactory(new MockAllMember(), new MockAllPlaylists(), new MockAllPlay());

    var actual = factory.createForPlay(1L, 1L);

    var expected = new EqualOwnerForPlay(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
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

  @Test
  void createForPlay_not_equal_owner() {
    var factory = new EqualOwnerFactory(new MockAllMember(), new MockAllPlaylists(), new MockAllPlay());

    assertThrows(NotOwnerException.class, () -> factory.createForPlay(2L, 1L));
  }
}