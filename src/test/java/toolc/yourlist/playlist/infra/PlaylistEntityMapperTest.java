package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlaylistEntityMapperTest {
  @Test
  void toPlaylist() {
    var mapper = new PlaylistEntityMapper();

    var actual =
      mapper.toPlaylist(Optional.of(new PlaylistEntity(1L, "My List", "panda.png")));

    var expected = Optional.of(Playlist.builder()
      .memberId(1L)
      .title("My List")
      .thumbnail("panda.png")
      .build());
    assertThat(actual, is(expected));
  }

  @Test
  void toPlaylist_entity_empty() {
    var mapper = new PlaylistEntityMapper();

    var actual =
      mapper.toPlaylist(Optional.empty());

    var expected = Optional.empty();
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
      Playlist.builder()
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Playlist.builder()
        .memberId(1L)
        .title("My Music")
        .thumbnail("puppy.png")
        .build()
    ));
    assertThat(actual, is(expected));
  }
}