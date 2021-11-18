package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toolc.yourlist.common.ResponseBody;
import toolc.yourlist.play.domain.PlaylistJson;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlaylistReadController {
  private final Playlist playlist;
  private final ThumbnailOfPlaylist thumbnailOfPlaylist;
  private final PlaylistMapper mapper = new PlaylistMapper();

  @GetMapping("/api/playlist/{id}")
  public ResponseEntity<?> readPlaylists(@PathVariable("id") Long memberId) {
    List<PlaylistJson> playlistJsons = toPlaylistJsonList(playlist.readWhatBelongsTo(memberId));

    ResponseBody responseBody = ResponseBody.builder()
      .status(OK.value())
      .message("조회 성공")
      .data(playlistJsons)
      .build();

    return ResponseEntity.ok(responseBody);
  }

  private List<PlaylistJson> toPlaylistJsonList(List<PlaylistEntity> playlistEntityList) {
    return playlistEntityList.stream()
      .map(playlistEntity ->
        mapper.toPlaylistJson(playlistEntity, thumbnailOfPlaylist.find(playlistEntity.id())))
      .collect(Collectors.toList());
  }

  @PostMapping("/create")
  public ResponseEntity<?> createPlaylist(@Valid @RequestBody JsonSaveRequest request) {
//    playlistStorage.save(request);
    ResponseBody responseBody = ResponseBody.builder()
      .status(OK.value())
      .message("생성 성공")
      .data(null)
      .build();

    return ResponseEntity.ok(responseBody);
  }

  private ResponseEntity<?> getBadRequestForExceed() {
    ResponseBody responseBody = ResponseBody.builder()
      .status(BAD_REQUEST.value())
      .message("[비회원] 생성 갯수 초과")
      .data(null)
      .build();

    return ResponseEntity.badRequest().body(responseBody);
  }
}
