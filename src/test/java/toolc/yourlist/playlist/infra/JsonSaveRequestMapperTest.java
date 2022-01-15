package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.Member;
import toolc.yourlist.playlist.domain.MockAllMember;
import toolc.yourlist.playlist.domain.SaveRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonSaveRequestMapperTest {
  @Test
  void toCreateRequest() {
    var mapper = new JsonSaveRequestMapper(new MockAllMember());

    var actual = mapper.toCreateRequest(new JsonSaveRequest(1L, "My List"));

    var expected = new SaveRequest(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build(),
      "My List");
    assertThat(actual, is(expected));
  }
}