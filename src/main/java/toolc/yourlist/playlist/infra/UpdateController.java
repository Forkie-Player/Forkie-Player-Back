package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UpdateController {
  private final Playlist playlist;

  @PutMapping("/api/playlist/update")
  public ResponseEntity<?> readPlaylists(@RequestBody JsonUpdateRequest request) {
    try {
      Optional<PlaylistEntity> playlistEntity = playlist.readBelongsTo(request.playlistId());

      if (playlistEntity.isEmpty()) {
        return JsonResponse.failForBadRequest("플레이리스트가 존재하지 않습니다.");
      }

      playlist.updateTitle(playlistEntity.get(), request.title());

      return JsonResponse.success("수정 성공");
    } catch (Exception e) {
      return JsonResponse.fail(e);
    }
  }
}
