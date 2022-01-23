

package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.Member;
import toolc.yourlist.playlist.domain.MockAllMember;
import toolc.yourlist.playlist.domain.ReadRequest;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MemberIdMapperTest {
  @Test
  void toReadRequest() {
    var mapper = new MemberIdMapper(new MockAllMember());

    var actual = mapper.toReadRequest("1");

    var expected = new ReadRequest(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build());
    assertThat(actual, is(right(expected)));
  }

  @Test
  void toReadRequest_not_number_format() {
    var mapper = new MemberIdMapper(new MockAllMember());

    var actual = mapper.toReadRequest("abc");

    var expected = "입력이 숫자 형식이 아닙니다.";
    assertThat(actual, is(left(expected)));
  }
}