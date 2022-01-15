package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonUpdateRequestMapperTest {
  @Test
  void toUpdateRequest() {
    var mapper = new JsonUpdateRequestMapper(new MockAllMember(), new MockAllPlaylists());

    var actual = mapper.toUpdateRequest(
      new JsonUpdateRequest(1L, 1L, "Happy Video"));

    var expected = new UpdateRequest(
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
        .build(),
      "Happy Video");
    assertThat(actual, is(expected));
  }
}