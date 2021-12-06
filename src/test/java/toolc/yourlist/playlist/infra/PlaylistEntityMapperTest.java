package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistEntityMapperTest {
  @Test
  void toPlaylist() {
    var mapper = new PlaylistEntityMapper();

    var actual =
      mapper.toPlaylist(new PlaylistEntity(1L, "My List", "panda.png"));

    var expected = new Playlist(1L, "My List", "panda.png");
    assertThat(actual, is(expected));
  }

  @Test
  void toListOfPlaylists() {
    var mapper = new PlaylistEntityMapper();

    var actual =
      mapper.toListOfPlaylists(List.of(
        new PlaylistEntity(1L, "My List", "panda.png"),
        new PlaylistEntity(1L, "My Music", "puppy.png")
      ));

    var expected = new ListOfPlaylists(List.of(
      new Playlist(1L, "My List", "panda.png"),
      new Playlist(1L, "My Music", "puppy.png")
    ));
    assertThat(actual, is(expected));
  }
}