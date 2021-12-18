package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistUpdaterTest {
  class MockAllMember implements AllMember {

    @Override
    public Optional<Member> findByLoginId(String loginId) {
      return Optional.empty();
    }

    @Override
    public Optional<Member> findById(Long id) {
      return Optional.of(Member.builder()
        .id(id)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build());
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
      return null;
    }
  }

  class MockAllPlaylists implements AllPlaylists {

    @Override
    public ListOfPlaylists readAllBelongsTo(Long memberId) {
      return null;
    }

    @Override
    public Optional<Playlist> readBelongsTo(Long id) {
      return Optional.of(Playlist.builder()
        .id(id)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build());
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 0;
    }

    @Override
    public void save(Playlist playlist) {
    }

    @Override
    public void updateTitleBelongsTo(Long playlistId, String title) {
    }
  }

  final AllMember allMember = new MockAllMember();
  final AllPlaylists allPlaylists = new MockAllPlaylists();

  @Test
  void updateTitle() {
    var updater = new PlaylistUpdater(allMember, allPlaylists);
    var request = new UpdateRequest(1L, 1L, "New List");

    var actual = updater.updateTitle(request);

    var expected = Optional.empty();
    assertThat(actual, is(expected));
  }
}