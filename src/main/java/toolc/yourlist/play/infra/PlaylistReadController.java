package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.ResponseBody;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.domain.PlaylistJson;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlaylistReadController {
  private final Playlist playlist;
  private final PlaylistMapper mapper;

  @GetMapping("/api/playlist/{id}")
  public ResponseEntity<?> readPlaylists(@PathVariable("id") Long memberId) {
    List<PlaylistJson> playlistJsons = mapper.toPlaylistJsonList(
      playlist.readWhatBelongsTo(memberId));

    ResponseBody responseBody = ResponseBody.builder()
      .status(OK.value())
      .message("조회 성공")
      .data(playlistJsons)
      .build();

    return ResponseEntity.ok(responseBody);
  }
}
