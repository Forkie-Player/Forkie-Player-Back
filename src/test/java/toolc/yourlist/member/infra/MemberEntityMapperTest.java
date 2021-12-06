package toolc.yourlist.member.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MemberEntityMapperTest {
  @Test
  void toMember() {
    var mapper = new MemberEntityMapper();

    var actual = mapper.toMember(
      Optional.of(new MemberEntity("oh980225", "qwer1234!", true)));

    var expected = Optional.of(
      Member.builder()
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build()
    );

    assertThat(actual, is(expected));
  }

  @Test
  void toMember_empty_entity() {
    var mapper = new MemberEntityMapper();

    var actual = mapper.toMember(Optional.empty());

    var expected = Optional.empty();
    assertThat(actual, is(expected));
  }
}