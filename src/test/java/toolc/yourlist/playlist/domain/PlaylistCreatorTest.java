package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistCreatorTest {
  class MockAllMember implements AllMember {
    @Override
    public Optional<Member> findByLoginId(String loginId) {
      return Optional.empty();
    }

    @Override
    public Optional<Member> findById(Long id) {
      return Optional.of(Member.builder()
        .id(id)
        .loginId("oh9802255")
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
      return Optional.empty();
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 5;
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
  void createPlaylist() {
    PlaylistCreator creator = new PlaylistCreator(allMember, allPlaylists);

    var actual = creator.createPlaylist(1L, "My List");

    var expected = Optional.empty();
    assertThat(actual, is(expected));
  }
}