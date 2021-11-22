package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.MockPlay;
import toolc.yourlist.play.infra.PlayEntity;
import toolc.yourlist.playlist.domain.PlaylistJson;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersistingPlaylistMapperTest {
  ThumbnailOfPlaylist thumbnailOfPlaylist;
  PlaylistMapper mapper;

  @Test
  void playlistJson로_변환() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder().build());
    mapper = new PlaylistMapper(thumbnailOfPlaylist);
    PlaylistJson playlistJson = mapper.toPlaylistJson(
      new Playlist(Optional.of(
        PlaylistEntity.builder()
          .title("title")
          .build())),
      "thumbnail");

    assertThat(playlistJson,
      is(PlaylistJson.builder()
        .title("title")
        .thumbnail("thumbnail")
        .build()));
  }

  @Test
  void playlist가_null() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder().build());
    mapper = new PlaylistMapper(thumbnailOfPlaylist);

    assertThrows(IllegalArgumentException.class, () ->
      mapper.toPlaylistJson(null, "thumbnail")
    );
  }

  @Test
  void playlistJsonList로_변환() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
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
    mapper = new PlaylistMapper(thumbnailOfPlaylist);

    List<PlaylistJson> playlistJsons = mapper.toPlaylistJsonList(
      new AllPlaylists(List.of(
        PlaylistEntity.builder()
          .title("title001")
          .memberId(1L)
          .build(),
        PlaylistEntity.builder()
          .title("title002")
          .memberId(1L)
          .build())));

    assertThat(playlistJsons
      , is(List.of(
        PlaylistJson.builder()
          .title("title001")
          .thumbnail("thumbnail1")
          .build(),
        PlaylistJson.builder()
          .title("title002")
          .thumbnail("thumbnail1")
          .build())));
  }
}