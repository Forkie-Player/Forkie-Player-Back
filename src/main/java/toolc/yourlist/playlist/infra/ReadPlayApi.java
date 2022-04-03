package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.member.domain.Auth;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.PlayReader;
import toolc.yourlist.playlist.domain.Plays;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.okWithData;

@RequiredArgsConstructor
@RestController
public class ReadPlayApi {
  private final JsonRequestMapper requestMapper;
  private final PlayReader reader;
  private final JsonResponseMapper responseMapper = new JsonResponseMapper();

  @GetMapping("/api/play")
  public ResponseEntity<?> readPlays(
    @Auth AuthenticationUser authenticationUser,
    @Valid @RequestBody JsonReadAllPlaysRequest jsonRequest) {
    return toOutput(reader.readAllPlays(requestMapper.toReadAllPlaysRequest(authenticationUser, jsonRequest)));
  }

  private ResponseEntity<?> toOutput(Plays result) {
    return okWithData(responseMapper.toPlayJsonList(result), "영상들 읽어오기 성공");
  }
}
