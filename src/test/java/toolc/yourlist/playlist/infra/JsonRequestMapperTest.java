package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.UpdateRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonRequestMapperTest {
  @Test
  void toUpdateRequest() {
    var mapper = new JsonRequestMapper();

    var actual = mapper.toUpdateRequest(JsonUpdateRequest.builder()
      .memberId(1L)
      .playlistId(1L)
      .title("My List")
      .build());

    var expected = new UpdateRequest(1L, 1L, "My List");
    assertThat(actual, is(expected));
  }
}