package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.play.domain.MockPlayRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static toolc.yourlist.PlayFixture.play;
import static toolc.yourlist.PlayFixture.playList;

class ThumbnailOfPlaylistTest {
  ThumbnailOfPlaylist thumbnailOfPlaylist;

  @Test
  void 썸네일_찾기() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlayRepository.builder()
      .findByPlaylistId(playlistId -> playList())
      .build());
    String thumbnail = this.thumbnailOfPlaylist.find(1L);

    assertThat("thumbnail", is(thumbnail));
  }

  @Test
  void 영상이_없음() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlayRepository.builder()
      .findByPlaylistId(playlistId -> Collections.emptyList())
      .build());
    String thumbnail = this.thumbnailOfPlaylist.find(1L);

    assertThat(null, is(thumbnail));
  }

  @Test
  void 첫번째_순서_중복() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlayRepository.builder()
      .findByPlaylistId(playlistId -> getDuplicateList())
      .build());
    assertThrows(IllegalArgumentException.class, () -> thumbnailOfPlaylist.find(1L));
  }

  private List<Play> getDuplicateList() {
    List<Play> playList = new ArrayList<>();
    playList.add(play().build());
    playList.add(play().build());

    return playList;
  }
}