package toolc.yourlist.playlist.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AddPlayApi {
  @GetMapping("/api/play")
  public ResponseEntity<?> addPlay(@RequestBody JsonAddPlayRequest jsonRequest) {
    // input:  json -> domain request로
    // time은 예외인가 아닌가... 우리는 애초에 프론트에서 거꾸로 입력이 안되게 막고 있다.
    // -> 그러면 바꿔서 들어오는 것은 예외이다..!
    // domain input
    // playlist, member, playInfo(time, channel, title, videoId) 정도!

    // logic: domain request를 이용한 domain 로직 처리

    // output: 적절한 json response!
    // (data 객체를 반환해야하면 해당 객체를 domain -> json으로)
    return null;
  }
}
