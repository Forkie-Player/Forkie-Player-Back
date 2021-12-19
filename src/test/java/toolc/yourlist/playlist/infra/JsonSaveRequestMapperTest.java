package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.CreateSaveRequest;
import toolc.yourlist.playlist.domain.SaveRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonSaveRequestMapperTest {
  class MockFactory implements CreateSaveRequest {

    @Override
    public Either<String, SaveRequest> create(Long memberId, String title) {
      return Either.right(new SaveRequest(Member.builder()
        .id(memberId)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build(),
        title));
    }
  }

  @Test
  void toCreateRequest() {
    var factory = new MockFactory();
    var mapper = new JsonSaveRequestMapper(factory);
    var jsonRequest = new JsonSaveRequest(1L, "My List");

    var actual = mapper.toCreateRequest(jsonRequest).get();

    var expected = new SaveRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build(),
      "My List");
    assertThat(actual, is(expected));
  }
}