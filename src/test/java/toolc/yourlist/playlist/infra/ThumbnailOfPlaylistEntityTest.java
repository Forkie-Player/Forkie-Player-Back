package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.MockPlay;
import toolc.yourlist.play.infra.PlayEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.PlayFixture.play;
import static toolc.yourlist.PlayFixture.playList;

class ThumbnailOfPlaylistEntityTest {
  ThumbnailOfPlaylist thumbnailOfPlaylist;

  @Test
  void 썸네일_찾기() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> playList())
      .build());
    String thumbnail = this.thumbnailOfPlaylist.find(1L);

    assertThat("thumbnail", is(thumbnail));
  }

  @Test
  void 영상이_없음() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> Collections.emptyList())
      .build());
    String thumbnail = this.thumbnailOfPlaylist.find(1L);

    assertThat(null, is(thumbnail));
  }

  @Test
  void 첫번째_순서_중복() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlay.builder()
      .readWhatBelongsTo(playlistId -> getDuplicateList())
      .build());
    assertThrows(IllegalArgumentException.class, () -> thumbnailOfPlaylist.find(1L));
  }

  private List<PlayEntity> getDuplicateList() {
    List<PlayEntity> playEntityList = new ArrayList<>();
    playEntityList.add(play().build());
    playEntityList.add(play().build());

    return playEntityList;
  }
}