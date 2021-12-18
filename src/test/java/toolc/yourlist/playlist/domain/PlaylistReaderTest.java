package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.infra.MemberEntity;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistReaderTest {
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
      return new ListOfPlaylists(List.of(Playlist.builder()
          .id(1L)
          .memberId(memberId)
          .title("My List")
          .thumbnail("panda.png")
          .build(),
        Playlist.builder()
          .id(2L)
          .memberId(memberId)
          .title("Good Music")
          .thumbnail("puppy.png")
          .build()));
    }

    @Override
    public Optional<Playlist> readBelongsTo(Long id) {
      return Optional.empty();
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
  void belongsTo() {
    var reader = new PlaylistReader(allMember, allPlaylists);

    var actual = reader.belongsTo(1L).get();

    var expected = new ListOfPlaylists(List.of(Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Playlist.builder()
        .id(2L)
        .memberId(1L)
        .title("Good Music")
        .thumbnail("puppy.png")
        .build()));
    assertThat(actual, is(expected));
  }
}