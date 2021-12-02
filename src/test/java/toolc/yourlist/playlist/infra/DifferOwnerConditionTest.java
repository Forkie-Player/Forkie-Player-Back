package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DifferOwnerConditionTest {
  class MockAllMember implements AllMember {

    @Override
    public Member findByLoginId(String loginId) {
      return null;
    }

    @Override
    public Member findById(Long id) {
      return new Member(id, "oh980225", true, "qwer1234!");
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
      return null;
    }
  }

  class MockReadPersisting implements ReadPersisting {
    @Override
    public AllPlaylists readAllBelongsTo(Long memberId) {
      return null;
    }

    @Override
    public Playlist readBelongsTo(Long id) {
      return Playlist.builder()
        .id(id)
        .title("My List")
        .thumbnail("panda.png")
        .memberId(1L)
        .build();
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 0;
    }
  }

  @Test
  void 영상목록의_주인O() {
    var condition = new DifferOwnerCondition(new MockAllMember(), new MockReadPersisting());

    var actual = condition.check(1L, 1L);

    assertThat(actual, is(true));
  }

  @Test
  void 영상목록의_주인X() {
    var condition = new DifferOwnerCondition(new MockAllMember(), new MockReadPersisting());

    var actual = condition.check(2L, 1L);

    assertThat(actual, is(false));
  }
}