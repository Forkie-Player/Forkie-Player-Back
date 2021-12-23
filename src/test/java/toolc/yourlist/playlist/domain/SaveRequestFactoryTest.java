package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SaveRequestFactoryTest {

  @Test
  void create() {
    var allMember = new MockAllMember();
    var factory = new SaveRequestFactory(allMember);

    var actual = factory.create(1L, "My List").get();

    var expected = new SaveRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build(),
      "My List");

    assertThat(actual, is(expected));
  }

  @Test
  void create_not_exist_member() {
    var allMember = new EmptyMember();
    var factory = new SaveRequestFactory(allMember);

    var actual = factory.create(1L, "My List").getLeft();

    assertThat(actual, is("존재하지 않는 회원"));
  }
}