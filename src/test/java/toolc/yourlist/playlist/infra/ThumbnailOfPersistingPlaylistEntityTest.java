package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.MockPlay;
import toolc.yourlist.play.infra.PlayEntity;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ThumbnailOfPersistingPlaylistEntityTest {

  @Test
  void 썸네일_찾기() {
    ThumbnailOfPlaylist thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> Arrays.asList(
        PlayEntity.builder()
          .sequence(1)
          .thumbnail("thumbnail001")
          .build(),
        PlayEntity.builder()
          .sequence(2)
          .thumbnail("thumbnail002")
          .build(),
        PlayEntity.builder()
          .sequence(3)
          .thumbnail("thumbnail003")
          .build()
      ))
      .build());
    String thumbnail = thumbnailOfPlaylist.find(1L);

    assertThat("thumbnail001", is(thumbnail));
  }

  @Test
  void 영상이_없음() {
    ThumbnailOfPlaylist thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> Collections.emptyList())
      .build());
    String thumbnail = thumbnailOfPlaylist.find(1L);

    assertThat(null, is(thumbnail));
  }

  @Test
  void 첫번째_순서_중복() {
    ThumbnailOfPlaylist thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> Arrays.asList(
        PlayEntity.builder()
          .sequence(1)
          .thumbnail("thumbnail001")
          .build(),
        PlayEntity.builder()
          .sequence(1)
          .thumbnail("thumbnail002")
          .build(),
        PlayEntity.builder()
          .sequence(2)
          .thumbnail("thumbnail003")
          .build()
      ))
      .build());
    assertThrows(IllegalArgumentException.class, () -> thumbnailOfPlaylist.find(1L));
  }
}