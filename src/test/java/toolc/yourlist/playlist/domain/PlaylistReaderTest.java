package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistReaderTest {
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

  final AllPlaylists allPlaylists = new MockAllPlaylists();

  @Test
  void belongsTo() {
    var reader = new PlaylistReader(allPlaylists);
    var request = new ReadRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build());

    var actual = reader.belongsTo(request).get();

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