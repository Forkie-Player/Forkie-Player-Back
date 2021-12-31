package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ListOfPlaylistsMapperTest {

  @Test
  void toPlaylistJsonList() {
    var mapper = new ListOfPlaylistsMapper();

    var actual = mapper.toPlaylistJsonList(new ListOfPlaylists(List.of(
      Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Playlist.builder()
        .id(2L)
        .memberId(1L)
        .title("My Music")
        .thumbnail("puppy.png")
        .build()
    )));

    var expected = List.of(
      new PlaylistJson(
        Playlist.builder()
          .id(1L)
          .memberId(1L)
          .title("My List")
          .thumbnail("panda.png")
          .build()
      ),
      new PlaylistJson(
        Playlist.builder()
          .id(2L)
          .memberId(1L)
          .title("My Music")
          .thumbnail("puppy.png")
          .build()
      ));

    assertThat(actual, is(expected));
  }
}