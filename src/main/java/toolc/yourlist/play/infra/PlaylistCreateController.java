package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.play.domain.SavePolicy;
import toolc.yourlist.play.domain.SaveRequest;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlaylistCreateController {
  private final Playlist playlist;
  private final SavePolicy savePolicy;
  private final PlaylistRequestMapper mapper;

  @PostMapping("/api/playlist/create")
  public ResponseEntity<?> createPlaylist(@Valid @RequestBody JsonSaveRequest request) {
    try {
      SaveRequest saveRequest = mapper.toSaveRequest(request);

      if (!savePolicy.matches(saveRequest)) {
        return JsonResponse.failForBadRequest("[비회원] 생성 갯수 초과");
      }

      playlist.saveByRequest(saveRequest);

      return JsonResponse.success("생성 성공");
    } catch (Exception e) {
      return JsonResponse.fail(e);
    }
  }
}
