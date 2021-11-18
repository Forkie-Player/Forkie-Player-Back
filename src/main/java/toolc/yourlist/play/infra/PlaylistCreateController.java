package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.ResponseBody;
import toolc.yourlist.play.domain.SavePolicy;
import toolc.yourlist.play.domain.SaveRequest;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlaylistCreateController {
  private final Playlist playlist;
  private final SavePolicy savePolicy;
  private final PlaylistRequestMapper mapper;

  @PostMapping("/api/playlist/create")
  public ResponseEntity<?> createPlaylist(@Valid @RequestBody JsonSaveRequest request) {
    SaveRequest saveRequest = mapper.toSaveRequest(request);

    if (!savePolicy.matches(saveRequest)) {
      return getBadRequestForExceed();
    }

    playlist.saveByRequest(saveRequest);

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
