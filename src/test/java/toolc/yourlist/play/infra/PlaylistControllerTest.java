package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import toolc.yourlist.common.ResponseBody;
import toolc.yourlist.play.domain.MockPlayRepository;
import toolc.yourlist.play.domain.MockPlaylistRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static toolc.yourlist.PlayFixture.playList;
import static toolc.yourlist.PlaylistFixture.*;

class PlaylistControllerTest {
  PlaylistStorage playlistStorage;
  ThumbnailOfPlaylist thumbnailOfPlaylist;
  PlaylistController controller;

  @Test
  void playlist목록_읽기() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlayRepository.builder()
      .findByPlaylistId(playlistId -> playList())
      .build());
    playlistStorage = new PlaylistStorage(MockPlaylistRepository.builder()
      .findByMemberId(memberId -> playlists())
      .build());
    controller = new PlaylistController(playlistStorage, thumbnailOfPlaylist);

    assertThat(controller.readPlaylists(1L), is(ResponseEntity.ok(ResponseBody.builder()
      .status(OK.value())
      .message("조회 성공")
      .data(playlistJsonList())
      .build())));
  }

  @Test
  void playlist생성() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlayRepository.builder().build());
    playlistStorage = new PlaylistStorage(MockPlaylistRepository.builder()
      .save(playlistEntity -> playlist().build())
      .build());
    controller = new PlaylistController(playlistStorage, thumbnailOfPlaylist);

    assertThat(controller.createPlaylist(
        new PlaylistSaveRequest(
          1L,
          "title",
          true,
          5)),
      is(ResponseEntity.ok(ResponseBody.builder()
        .status(OK.value())
        .message("생성 성공")
        .data(null)
        .build())));
  }

  @Test
  void playlist생성_비회원_5개초과() {
    thumbnailOfPlaylist = new ThumbnailOfPlaylist(MockPlayRepository.builder().build());
    playlistStorage = new PlaylistStorage(MockPlaylistRepository.builder()
      .save(playlistEntity -> playlist().build())
      .build());
    controller = new PlaylistController(playlistStorage, thumbnailOfPlaylist);

    assertThat(controller.createPlaylist(
        new PlaylistSaveRequest(
          1L,
          "title",
          false,
          5)),
      is(ResponseEntity.badRequest()
        .body(ResponseBody.builder()
          .status(BAD_REQUEST.value())
          .message("[비회원] 생성 갯수 초과")
          .data(null)
          .build())));
  }
}