package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.TimeUpdater;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@RestController
@RequiredArgsConstructor
public class UpdateTimeApi {
  private final JsonRequestMapper mapper;
  private final TimeUpdater updater;

  @PatchMapping("api/play/time")
  public ResponseEntity<?> update(@RequestBody JsonUpdateTimeRequest jsonRequest) {
    updater.update(mapper.toTimeUpdateRequest(jsonRequest));

    return ok("영상 시간 수정 성공");
  }
}
