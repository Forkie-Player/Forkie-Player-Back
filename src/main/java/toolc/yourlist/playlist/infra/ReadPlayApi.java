package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.playlist.domain.Plays;
import toolc.yourlist.playlist.domain.PlayReader;

import static toolc.yourlist.common.infra.JsonResponse.okWithData;

@RequiredArgsConstructor
@RestController
public class ReadPlayApi {
  private final JsonRequestMapper requestMapper;
  private final PlayReader reader;
  private final JsonResponseMapper responseMapper = new JsonResponseMapper();

  // TODO: 현재는 그냥 requestBody로 받지만 지수꺼 토큰이 완성되면
  //  토큰을 받고
  //  PathVariable로 playlistId를 받을 예정
  @GetMapping("/api/play")
  public ResponseEntity<?> readPlays(@RequestBody JsonReadAllPlaysRequest jsonRequest) {
    return toOutput(reader.readAllPlays(requestMapper.toReadAllPlaysRequest(jsonRequest)));
  }

  private ResponseEntity<?> toOutput(Plays result) {
    return okWithData(responseMapper.toPlayJsonList(result), "영상들 읽어오기 성공");
  }
}
