package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.PlayEliminator;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@RequiredArgsConstructor
@RestController
public class ExceptPlayApi {
  private final PlayEliminator eliminator;
  private final JsonRequestMapper mapper;

  @DeleteMapping("/api/play")
  public ResponseEntity<?> delete(@Valid @RequestBody JsonExceptPlayRequest jsonRequest) {
    eliminator.delete(mapper.toValidRequestForPlay(jsonRequest));

    return ok("영상 목록 내 영상 제외 성공");
  }
}
