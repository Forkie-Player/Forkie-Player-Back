package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class EqualOwnerConditionTest {
  @Test
  void 영상목록의_주인O() {
    var condition = new EqualOwnerCondition();

    var actual = condition.check(
      Member.builder()
        .id(1L)
        .isMember(true)
        .loginId("oh980225")
        .password("qwer1234!")
        .build(),
      Playlist.builder()
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build()
    );

    assertThat(actual, is(true));
  }

  @Test
  void 영상목록의_주인X() {
    var condition = new EqualOwnerCondition();

    var actual = condition.check(
      Member.builder()
        .id(1L)
        .isMember(true)
        .loginId("oh980225")
        .password("qwer1234!")
        .build(),
      Playlist.builder()
        .memberId(2L)
        .title("My List")
        .thumbnail("panda.png")
        .build()
    );

    assertThat(actual, is(false));
  }
}