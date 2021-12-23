package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ReadRequestFactoryTest {

  @Test
  void create() {
    var allMember = new MockAllMember();
    var factory = new ReadRequestFactory(allMember);

    var actual = factory.create("1").get();

    var expected = new ReadRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build());
    assertThat(actual, is(expected));
  }

  @Test
  void create_not_null() {
    var allMember = new EmptyMember();
    var factory = new ReadRequestFactory(allMember);

    var actual = factory.create(null).getLeft();

    assertThat(actual, is("입력이 비어있습니다."));
  }

  @Test
  void create_not_exist_member() {
    var allMember = new EmptyMember();
    var factory = new ReadRequestFactory(allMember);

    var actual = factory.create("1").getLeft();

    assertThat(actual, is("존재하지 않는 회원"));
  }

  @Test
  void create_not_number() {
    var allMember = new EmptyMember();
    var factory = new ReadRequestFactory(allMember);

    var actual = factory.create("abc").getLeft();

    assertThat(actual, is("입력이 숫자 형식이 아닙니다."));
  }
}