package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.MockPlay;
import toolc.yourlist.play.infra.PlayEntity;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.PlaylistJson;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PersistingPlaylistMapperTest {
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
        new Playlist(1L, 1L, "My Music"),
        new Playlist(2L, 1L, "My Movie"))));

    assertThat(playlistJsons
      , is(List.of(
        PlaylistJson.builder()
          .playlist(new Playlist(1L, 1L, "My Music"))
          .thumbnail("thumbnail1")
          .build(),
        PlaylistJson.builder()
          .playlist(new Playlist(1L, 1L, "My Movie"))
          .thumbnail("thumbnail1")
          .build())));
  }
}