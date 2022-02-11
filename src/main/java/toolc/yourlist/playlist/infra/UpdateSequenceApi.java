package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.SequenceUpdater;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@RestController
@RequiredArgsConstructor
public class UpdateSequenceApi {
  private final JsonRequestMapper mapper;
  private final SequenceUpdater updater;

  @PatchMapping("api/play/sequence")
  public ResponseEntity<?> update(@RequestBody JsonUpdateSequenceRequest jsonRequest) {
    updater.update(mapper.toPlaySequencesForUpdate(jsonRequest));

    return ok("영상 순서 수정 성공");
  }
}
