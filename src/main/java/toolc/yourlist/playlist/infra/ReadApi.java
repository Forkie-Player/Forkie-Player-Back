package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.PlaylistJson;

import javax.validation.constraints.NotBlank;
import java.util.List;

import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;
import static toolc.yourlist.common.infra.JsonResponse.successWithData;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReadApi {
  private final PlaylistReader reader;
  private final LoginIdMapper loginIdMapper;
  private final PlaylistWithThumbnailMapper playlistWithThumbnailMapper = new PlaylistWithThumbnailMapper();

  @GetMapping("/api/playlist/{loginId}")
  public ResponseEntity<?> readPlaylists(@NotBlank @PathVariable("loginId") String loginId) {
    var readRequest = loginIdMapper.toReadRequest(loginId);

    if (readRequest.isEmpty()) {
      return failForBadRequest(readRequest.getLeft());
    }

    return toOutput(playlistWithThumbnailMapper.toPlaylistJson(reader.readAllPlaylists(loginId)));
  }

  private ResponseEntity<?> toOutput(List<PlaylistJson> playlistJsons) {
    return successWithData(playlistJsons, "조회 성공");
  }
}
