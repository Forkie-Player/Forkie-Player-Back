package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.PlaylistEliminator;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;
import static toolc.yourlist.common.infra.JsonResponse.ok;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DeleteApi {
  private final PlaylistEliminator eliminator;
  private final JsonRequestMapper mapper;

  @DeleteMapping("/api/playlist")
  public ResponseEntity<?> delete(@Valid @RequestBody JsonDeleteRequest jsonRequest) {
    eliminator.delete(mapper.toDeleteRequest(jsonRequest));

    return ok("삭제 성공");
  }
}
