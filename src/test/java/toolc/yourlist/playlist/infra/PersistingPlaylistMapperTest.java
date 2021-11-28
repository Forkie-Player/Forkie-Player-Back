package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.MockPlay;
import toolc.yourlist.play.infra.PlayEntity;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.PlaylistJson;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersistingPlaylistMapperTest {

  @Test
  void playlistJson로_변환() {
    ThumbnailOfPlaylist thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder().build());
    PlaylistMapper mapper = new PlaylistMapper(thumbnailOfPlaylist);
    PlaylistJson playlistJson = mapper.toPlaylistJson(
      new Playlist(1L, "My List"), "thumbnail");

    assertThat(playlistJson,
      is(PlaylistJson.builder()
        .title("My List")
        .thumbnail("thumbnail")
        .build()));
  }

  @Test
  void playlist가_null() {
    ThumbnailOfPlaylist thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder().build());
    PlaylistMapper mapper = new PlaylistMapper(thumbnailOfPlaylist);

    assertThrows(IllegalArgumentException.class, () ->
      mapper.toPlaylistJson(null, "thumbnail")
    );
  }

  @Test
  void playlistJsonList로_변환() {
    ThumbnailOfPlaylist thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> Arrays.asList(
        PlayEntity.builder()
          .sequence(1)
          .thumbnail("thumbnail1")
          .build(),
        PlayEntity.builder()
          .sequence(2)
          .thumbnail("thumbnail2")
          .build(),
        PlayEntity.builder()
          .sequence(3)
          .thumbnail("thumbnail3")
          .build()
      ))
      .build());
    PlaylistMapper mapper = new PlaylistMapper(thumbnailOfPlaylist);

    List<PlaylistJson> playlistJsons = mapper.toPlaylistJsonList(
      new AllPlaylists(List.of(
        new PlaylistEntity(1L, "My Music"),
        new PlaylistEntity(1L, "My Movie"))));

    assertThat(playlistJsons
      , is(List.of(
        PlaylistJson.builder()
          .title("My Music")
          .thumbnail("thumbnail1")
          .build(),
        PlaylistJson.builder()
          .title("My Movie")
          .thumbnail("thumbnail1")
          .build())));
  }
}