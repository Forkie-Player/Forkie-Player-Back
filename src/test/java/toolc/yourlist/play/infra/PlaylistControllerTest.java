package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import toolc.yourlist.common.ResponseBody;
import toolc.yourlist.play.domain.MockPlayRepository;
import toolc.yourlist.play.domain.MockPlaylistRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;
import static toolc.yourlist.PlayFixture.playEntityList;
import static toolc.yourlist.PlaylistFixture.playlistEntityList;
import static toolc.yourlist.PlaylistFixture.playlistJsonList;

class PlaylistControllerTest {
  AllPlaylists allPlaylists;
  ThumbnailOfPlaylist thumbnailOfPlaylist;
  PlaylistController controller;

  @Test
  void playlist목록_읽기() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlayRepository.builder()
      .findByPlaylistId(playlistId -> playEntityList())
      .build());
    allPlaylists = new AllPlaylists(MockPlaylistRepository.builder()
      .findByMemberId(memberId -> playlistEntityList())
      .build());
    controller = new PlaylistController(allPlaylists, thumbnailOfPlaylist);

    assertThat(controller.readPlaylists(1L), is(ResponseEntity.ok(ResponseBody.builder()
      .status(OK.value())
      .message("조회 성공")
      .data(playlistJsonList())
      .build())));
  }
}