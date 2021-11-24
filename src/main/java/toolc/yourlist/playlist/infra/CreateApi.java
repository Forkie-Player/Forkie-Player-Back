package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.playlist.domain.SavePolicy;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CreateApi {
  private final PersistingPlaylist persistingPlaylist;
  private final SavePolicy savePolicy;
  private final JsonSaveRequestMapper mapper;

  @PostMapping("/api/playlist/create")
  public ResponseEntity<?> createPlaylist(@Valid @RequestBody JsonSaveRequest request) {
    var saveRequest = mapper.toSaveRequest(request);

    if (saveRequest.isEmpty()) {
      return failForBadRequest(saveRequest.getLeft());
    }
    if (!savePolicy.matches(saveRequest.get())) {
      return failForBadRequest("[비회원] 생성 갯수 초과");
    }

    persistingPlaylist.saveByRequest(saveRequest.get());
    return JsonResponse.success("생성 성공");
  }
}
