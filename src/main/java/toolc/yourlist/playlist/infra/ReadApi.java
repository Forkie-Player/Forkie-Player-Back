package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.ReadPlaylist;

import javax.validation.constraints.NotBlank;
import java.util.List;

import static toolc.yourlist.common.infra.JsonResponse.successWithData;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReadApi {
  private final ReadPlaylist readPlaylist;
  private final ListOfPlaylistsMapper listOfPlaylistsMapper = new ListOfPlaylistsMapper();

  @GetMapping("/api/playlist/{memberId}")
  public ResponseEntity<?> readPlaylists(@NotBlank @PathVariable("memberId") Long memberId) {
    return toOutput(
      listOfPlaylistsMapper.toPlaylistJsonList(
        readPlaylist.allBelongsTo(memberId)));
  }

  private ResponseEntity<?> toOutput(List<PlaylistJson> playlistJsons) {
    return successWithData(playlistJsons, "조회 성공");
  }
}
