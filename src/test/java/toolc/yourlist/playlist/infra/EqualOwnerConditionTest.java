package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.playlist.domain.Playlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class EqualOwnerConditionTest {
  @Test
  void 영상목록의_주인O() {
    AllMember allMember = MockAllMember.builder()
      .findById(id -> new Member(1L, "oh980225", true, "qwer1234!"))
      .build();
    EqualOwnerCondition condition = new EqualOwnerCondition(allMember);

    var actual = condition.check(
      new Member(1L, "oh980225", true, "qwer1234!"),
      new Playlist(1L, 1L, "My List"));

    assertThat(actual, is(true));
  }

  @Test
  void 영상목록의_주인X() {
    AllMember allMember = MockAllMember.builder()
      .findById(id -> new Member(1L, "oh980225", true, "qwer1234!"))
      .build();
    EqualOwnerCondition condition = new EqualOwnerCondition(allMember);

    var actual = condition.check(
      new Member(2L, "oh1263", true, "abcd1234!"),
      new Playlist(1L, 1L, "My List"));
    assertThat(actual, is(false));
  }
}