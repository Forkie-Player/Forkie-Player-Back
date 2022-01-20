package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.PlaylistUpdater;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;
import static toolc.yourlist.common.infra.JsonResponse.ok;

@Slf4j
@RequiredArgsConstructor
@RestController
class UpdateApi {
  private final PlaylistUpdater updater;
  private final JsonRequestMapper mapper;

  @PutMapping("/api/playlist")
  public ResponseEntity<?> updateTitle(@Valid @RequestBody JsonUpdateRequest jsonRequest) {
    updater.updateTitle(mapper.toUpdateRequest(jsonRequest));

    return ok("수정 성공");
  }
}