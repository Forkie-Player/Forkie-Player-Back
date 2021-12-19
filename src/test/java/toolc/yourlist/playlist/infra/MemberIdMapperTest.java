package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.CreateReadRequest;
import toolc.yourlist.playlist.domain.ReadRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MemberIdMapperTest {
  class MockFactory implements CreateReadRequest {

    @Override
    public Either<String, ReadRequest> create(Long memberId) {
      return Either.right(new ReadRequest(Member.builder()
        .id(memberId)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build()));
    }
  }

  @Test
  void toReadRequest() {
    var factory = new MockFactory();
    var mapper = new MemberIdMapper(factory);

    var actual = mapper.toReadRequest("1").get();

    var expected = new ReadRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build());

    assertThat(actual, is(expected));
  }

  @Test
  void toReadRequest_null() {
    var factory = new MockFactory();
    var mapper = new MemberIdMapper(factory);

    var actual = mapper.toReadRequest(null).getLeft();

    assertThat(actual, is("입력이 비어있습니다."));
  }

  @Test
  void toReadRequest_not_number() {
    var factory = new MockFactory();
    var mapper = new MemberIdMapper(factory);

    var actual = mapper.toReadRequest("one").getLeft();

    assertThat(actual, is("입력이 숫자 형식이 아닙니다."));
  }
}