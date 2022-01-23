package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EqualOwnerFactoryTest {

  @Test
  void create() {
    var factory = new EqualOwnerFactory(new MockAllMember(), new MockAllPlaylists());

    var actual = factory.create(1L, 1L);

    var expected = new EqualOwner(
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
  void create_not_equal_owner() {
    var factory = new EqualOwnerFactory(new MockAllMember(), new MockAllPlaylists());

    assertThrows(NotOwnerException.class, () -> factory.create(2L, 1L));
  }
}