package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.PlaylistReader;

import java.util.List;

import static toolc.yourlist.common.infra.JsonResponse.ok;
import static toolc.yourlist.common.infra.JsonResponse.okWithData;

@Slf4j
@RequiredArgsConstructor
@RestController
class ReadApi {
  private final PlaylistReader reader;
  private final ListOfPlaylistsMapper listOfPlaylistsMapper = new ListOfPlaylistsMapper();

  @GetMapping("/api/playlist/{memberId}")
  public ResponseEntity<?> readPlaylists(@PathVariable("memberId") Long memberId) {
    var result = reader.belongsTo(memberId);

    if (result.isEmpty()) {
      return ok("조회 실패: " + result.getLeft());
    }

    return toOutput(listOfPlaylistsMapper.toPlaylistJsonList(result.get()));
  }

  private ResponseEntity<?> toOutput(List<PlaylistJson> playlistJsons) {
    return okWithData(playlistJsons, "조회 성공");
  }
}
