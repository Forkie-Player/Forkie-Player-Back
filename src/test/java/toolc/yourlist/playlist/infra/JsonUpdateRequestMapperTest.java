package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.CreateUpdateRequest;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.UpdateRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonUpdateRequestMapperTest {

  class MockFactory implements CreateUpdateRequest {

    @Override
    public Either<String, UpdateRequest> create(Long memberId, Long playlistId, String newTitle) {
      return Either.right(new UpdateRequest(Member.builder()
        .id(memberId)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build(),
        Playlist.builder()
          .id(playlistId)
          .memberId(memberId)
          .title("My List")
          .thumbnail("panda.png")
          .build(),
        newTitle));
    }
  }

  @Test
  void toUpdateRequest() {
    var factory = new MockFactory();
    var mapper = new JsonUpdateRequestMapper(factory);
    var jsonRequest = new JsonUpdateRequest(1L, 1L, "My Music");

    var actual = mapper.toUpdateRequest(jsonRequest).get();

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
      "My Music");
    assertThat(actual, is(expected));
  }
}