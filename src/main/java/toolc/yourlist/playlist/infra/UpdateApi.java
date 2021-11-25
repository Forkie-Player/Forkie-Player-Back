package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UpdateApi {
  private final PersistingPlaylist persistingPlaylist;
  JsonUpdateRequestMapper mapper;

  @PutMapping("/api/playlist/update")
  public ResponseEntity<?> updateTitle(@RequestBody JsonUpdateRequest request) {
    var updateRequest = mapper.toUpdateRequest(request);

    if (updateRequest.isEmpty()) {
      return JsonResponse.failForBadRequest(updateRequest.getLeft());
    }

    Playlist playlist = persistingPlaylist.readBelongsTo(updateRequest.get().playlistId());
    persistingPlaylist.updateTitle(playlist, updateRequest.get());

    return JsonResponse.success("수정 성공");
  }
}
