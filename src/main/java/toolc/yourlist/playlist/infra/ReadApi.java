package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.member.domain.Auth;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.PlaylistReader;
import toolc.yourlist.playlist.domain.User;

import java.util.List;

import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;
import static toolc.yourlist.common.infra.JsonResponse.okWithData;

@Slf4j
@RequiredArgsConstructor
@RestController
class ReadApi {
  private final PlaylistReader reader;
  private final StringConverter converter = new StringConverter();
  private final JsonResponseMapper jsonResponseMapper = new JsonResponseMapper();

  @GetMapping("/api/playlist")
  public ResponseEntity<?> readPlaylists(@Auth AuthenticationUser authenticationUser) {
    return toOutput(jsonResponseMapper.toPlaylistJsonList(reader.belongsTo(new User(authenticationUser))));
  }

  private ResponseEntity<?> failRead(String message) {
    return failForBadRequest("조회 실패: " + message);
  }

  private ResponseEntity<?> toOutput(List<PlaylistJson> playlistJsons) {
    return okWithData(playlistJsons, "조회 성공");
  }
}
