package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UpdateApi {
  private final PlaylistUpdater updater;

  @PutMapping("/api/playlist")
  public ResponseEntity<?> updateTitle(@Valid @RequestBody JsonUpdateRequest request) {
    updater.updateTitle(
      request.memberId(),
      request.playlistId(),
      request.title()
    );

    return JsonResponse.success("수정 성공");
  }
}


//  @PutMapping("/api/playlist/update")
//  public ResponseEntity<?> updateTitle(@Valid @RequestBody JsonUpdateRequest request) {
//    var updateRequest = mapper.toUpdateRequest(request);
//
//    if (updateRequest.isEmpty()) {
//      return JsonResponse.failForBadRequest(updateRequest.getLeft());
//    }
//
//    return toOutput(updateRequest);
//  }