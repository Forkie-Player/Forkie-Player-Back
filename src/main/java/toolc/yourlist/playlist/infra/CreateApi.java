package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.playlist.domain.CreatePlaylist;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
class CreateApi {
  private final CreatePlaylist creator;

  @PostMapping("/api/playlist")
  public ResponseEntity<?> create(@Valid @RequestBody JsonSaveRequest request) {
    creator.createPlaylist(request.memberId(), request.title());
    return JsonResponse.success("생성 성공");
  }
}
