package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.PlayReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlayReaderTest {
  @Test
  void readAllPlays() {
    var reader = new PlayReader();
    var request = new ReadAllPlaysRequest(new EqualOwner(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qewr1234!")
        .isMember(true)
        .build(),
      Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build()));

    var actual = reader.read(request);

    var expected = new ListOfPlays();
    assertThat(actual, is(expected));
  }
}
