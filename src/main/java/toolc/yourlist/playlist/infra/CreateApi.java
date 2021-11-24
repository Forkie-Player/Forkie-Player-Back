package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.domain.Result;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.playlist.domain.SavePolicy;
import toolc.yourlist.playlist.domain.SaveRequest;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CreateApi {
  private final PersistingPlaylist persistingPlaylist;
  private final SavePolicy savePolicy;
  private final RequestMapper mapper;

  @PostMapping("/api/playlist/create")
  public ResponseEntity<?> createPlaylist(@Valid @RequestBody JsonSaveRequest request) {
    Result<SaveRequest> saveRequest = mapper.toSaveRequest(request);

    if (saveRequest.isFail()) {
      return saveRequest.fail();
    }
    if (!savePolicy.matches(saveRequest.success())) {
      return JsonResponse.failForBadRequest("[비회원] 생성 갯수 초과");
    }

    persistingPlaylist.saveByRequest(saveRequest.success());

    return JsonResponse.success("생성 성공");
  }
}
