package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.member.domain.Auth;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.PlayReader;
import toolc.yourlist.playlist.domain.Plays;

import static toolc.yourlist.common.infra.JsonResponse.okWithData;

@RequiredArgsConstructor
@RestController
public class ReadPlayApi {
  private final JsonRequestMapper requestMapper;
  private final PlayReader reader;
  private final JsonResponseMapper responseMapper = new JsonResponseMapper();

  @GetMapping("/api/play/{playlistId}")
  public ResponseEntity<?> readPlays(
    @Auth AuthenticationUser authenticationUser,
    @PathVariable("playlistId") Long playlistId) {
    return toOutput(reader.readAllPlays(requestMapper.toReadAllPlaysRequest(authenticationUser, playlistId)));
  }

  private ResponseEntity<?> toOutput(Plays result) {
    return okWithData(responseMapper.toPlayJsonList(result), "영상들 읽어오기 성공");
  }
}
