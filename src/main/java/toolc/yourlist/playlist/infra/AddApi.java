package toolc.yourlist.playlist.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AddApi {
  @GetMapping("/api/play")
  public ResponseEntity<?> addPlay(@RequestBody JsonAddRequest jsonRequest) {
    // input:  json -> domain request로

    // logic: domain request를 이용한 domain 로직 처리

    // output: 적절한 json response!
    // (data 객체를 반환해야하면 해당 객체를 domain -> json으로)
    return null;
  }
}
