package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.Playlists;
import toolc.yourlist.playlist.domain.exception.NoExistPlaylistException;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlaylistEntityMapperTest {

  @Test
  void toPlaylist() {
    var mapper = new PlaylistEntityMapper();

    var actual =
      mapper.toPlaylist(Optional.of(new PlaylistEntity(1L, "My List", "panda.png")));

    var expected = Playlist.builder()
      .memberId(1L)
      .title("My List")
      .thumbnail("panda.png")
      .build();
    assertThat(actual, is(expected));
  }

  @Test
  void toPlaylist_entity_empty() {
    var mapper = new PlaylistEntityMapper();

    assertThrows(NoExistPlaylistException.class, () -> mapper.toPlaylist(Optional.empty()));
  }

  @Test
  void toListOfPlaylists() {
    var mapper = new PlaylistEntityMapper();

    var actual =
      mapper.toListOfPlaylists(List.of(
        new PlaylistEntity(1L, "My List", "panda.png"),
        new PlaylistEntity(1L, "My Music", "puppy.png")
      ));

    var expected = new Playlists(List.of(
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