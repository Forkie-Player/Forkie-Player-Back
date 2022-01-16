package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.PlayAdder;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@RestController
@RequiredArgsConstructor
class AddPlayApi {
  private final JsonAddPlayRequestMapper mapper;
  private final PlayAdder adder;

  @PostMapping("/api/play")
  public ResponseEntity<?> addPlay(@RequestBody JsonAddPlayRequest jsonRequest) {
    var request = mapper.toAddPlayRequest(jsonRequest);

    adder.add(request);

    return ok("영상 추가 성공");
  }
}
