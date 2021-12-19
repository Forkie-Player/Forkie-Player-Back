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
  private final JsonCreateRequestMapper mapper;

  @PostMapping("/api/playlist")
  public ResponseEntity<?> create(@Valid @RequestBody JsonCreateRequest jsonRequest) {
    var request = mapper.toCreateRequest(jsonRequest);
    if (request.isEmpty()) {
      return failCreate(request.getLeft());
    }

    var result = creator.createPlaylist(request.get());
    if (result.isEmpty()) {
      return failCreate(result.getLeft());
    }

    return JsonResponse.ok("생성 성공");
  }

  private ResponseEntity<?> failCreate(String message) {
    return ok("생성 실패: " + message);
  }
}
