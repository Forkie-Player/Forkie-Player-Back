package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.playlist.domain.Playlist;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UpdateApi {
  private final PersistingPlaylist persistingPlaylist;
  private final JsonUpdateRequestMapper mapper;

  @PutMapping("/api/playlist/update")
  public ResponseEntity<?> updateTitle(@RequestBody JsonUpdateRequest request) {
    var updateRequest = mapper.toUpdateRequest(request);

    if (updateRequest.isEmpty()) {
      return JsonResponse.failForBadRequest(updateRequest.getLeft());
    }

    return toOutput(updateRequest);
  }

  private ResponseEntity<?> toOutput(Either<String, UpdateRequest> updateRequest) {
    Playlist playlist = persistingPlaylist.readBelongsTo(updateRequest.get().playlistId());
    persistingPlaylist.updateTitle(playlist, updateRequest.get());
    return JsonResponse.success("수정 성공");
  }
}
