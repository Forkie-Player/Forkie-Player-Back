package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.UpdatePlaylist;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@Slf4j
@RequiredArgsConstructor
@RestController
class UpdateApi {
  private final UpdatePlaylist updater;
  private final JsonRequestMapper mapper = new JsonRequestMapper();

  @PutMapping("/api/playlist")
  public ResponseEntity<?> updateTitle(@Valid @RequestBody JsonUpdateRequest request) {
    var message = updater.updateTitle(mapper.toUpdateRequest(request));

    if (message.isPresent()) {
      return ok("수정 실패: " + message.get());
    }

    return ok("수정 성공");
  }
}