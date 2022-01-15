package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonDeleteRequestMapperTest {
  @Test
  void toDeleteRequest() {
    var mapper = new JsonDeleteRequestMapper(new MockAllMember(), new MockAllPlaylists());

    var actual = mapper.toDeleteRequest(new JsonDeleteRequest(1L, 1L));

    var expected = new DeleteRequest(
      Member.builder()
        .id(1L)
        .isMember(true)
        .loginId("oh980225")
        .password("qwer1234!")
        .build(),
      Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build());
    assertThat(actual, is(expected));
  }
}