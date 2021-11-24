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

  @PutMapping("/api/playlist/update")
  public ResponseEntity<?> readPlaylists(@RequestBody JsonUpdateRequest request) {
    Playlist playlist = persistingPlaylist.readBelongsTo(request.playlistId());
    persistingPlaylist.updateTitle(playlist, request.title());

    return JsonResponse.success("수정 성공");
  }
}
