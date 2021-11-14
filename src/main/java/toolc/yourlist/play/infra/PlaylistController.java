package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.ResponseBody;
import toolc.yourlist.play.domain.PlaylistJson;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
  private final AllPlaylists allPlaylists;
  private final ThumbnailOfPlaylist thumbnailOfPlaylist;
  private final PlaylistMapper mapper = new PlaylistMapper();

  @GetMapping("/{id}")
  public ResponseEntity<?> readPlaylists(@PathVariable("id") Long memberId) { // TODO: 입력이 Token으로 변경될 것
    List<PlaylistJson> playlistJsons = toPlaylistJsonList(allPlaylists.belongsTo(memberId));

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
}
