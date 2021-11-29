package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.PlaylistWithThumbnail;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistReaderTest {
  class MockReadPersisting implements ReadPersisting {
    @Override
    public AllPlaylists readAllBelongsTo(String loginId) {
      return new AllPlaylists(List.of(
        new Playlist(1L, 1L, "My List"),
        new Playlist(2L, 1L, "My Music"),
        new Playlist(3L, 1L, "Game")));
    }

    @Override
    public Playlist readBelongsTo(Long id) {
      return null;
    }

    @Override
    public long havingCountOf(Long memberId) {
      return 0;
    }
  }

  class MockReadThumbnail implements ReadThumbnail {
    @Override
    public String find(Long playlistId) {
      return "puppy.img";
    }
  }

  @Test
  void readAllPlaylists() {
    PlaylistReader reader = new PlaylistReader(new MockReadPersisting(), new MockReadThumbnail());
    var actual = reader.readAllPlaylists("oh980225");

    var expected = List.of(
      new PlaylistWithThumbnail(1L, "My List", "puppy.img"),
      new PlaylistWithThumbnail(2L, "My Music", "puppy.img"),
      new PlaylistWithThumbnail(3L, "Game", "puppy.img"));

    assertThat(actual, is(expected));
  }
}