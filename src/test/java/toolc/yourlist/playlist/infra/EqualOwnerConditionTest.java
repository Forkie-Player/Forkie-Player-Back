package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class EqualOwnerConditionTest {
  @Test
  void 영상목록의_주인O() {
    AllMember allMember = MockAllMember.builder()
      .findById(id -> new Member(
        Optional.of(
          new MemberEntity("oh980225", "qwer1234!", true)
        )))
      .build();
    EqualOwnerCondition condition = new EqualOwnerCondition(allMember);

    var actual = condition.check(
      new Member(
        Optional.of(
          new MemberEntity("oh980225", "qwer1234!", true)
        )),
      new Playlist(1L, "My List"));

    assertThat(actual, is(true));
  }

  @Test
  void 영상목록의_주인X() {
    AllMember allMember = MockAllMember.builder()
      .findById(id -> new Member(
        Optional.of(
          new MemberEntity("oh980225", "qwer1234!", true)
        )))
      .build();
    EqualOwnerCondition condition = new EqualOwnerCondition(allMember);

    var actual = condition.check(
      new Member(
        Optional.of(
          new MemberEntity("oh1263", "abcd1234!", true)
        )),
      new Playlist(1L, "My List"));
    assertThat(actual, is(false));
  }
}