package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.playlist.domain.PlaylistCreator;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@Slf4j
@RequiredArgsConstructor
@RestController
class CreateApi {
  private final PlaylistCreator creator;

  @PostMapping("/api/playlist")
  public ResponseEntity<?> create(@Valid @RequestBody JsonSaveRequest request) {
    var message = creator.createPlaylist(request.memberId(), request.title());

    if (message.isPresent()) {
      return ok("생성 실패: " + message.get());
    }

    return JsonResponse.ok("생성 성공");
  }
}
