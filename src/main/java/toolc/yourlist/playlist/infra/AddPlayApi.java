package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class AddPlayApi {
  private final JsonAddPlayRequestMapper mapper;

  @GetMapping("/api/play")
  public ResponseEntity<?> addPlay(@RequestBody JsonAddPlayRequest jsonRequest) {
    var request = mapper.toAddPlayRequest(jsonRequest);

    // logic: domain request를 이용한 domain 로직 처리
    // 입력으로 들어온 play를 영속화해줘야한다. -> DB저장
    // 근데 이때 저장을 하기 위해서는 요청자와 영상 목록 주인이 동일해야한다. -> 아닌 경우는 예외
    // play의 순서는 해당 영상목록의 사이즈 + 1이다.
    // 그리고 혹시 해당 사이즈가 0일 경우, 즉 그 play가 첫 영상일 경우에는
    // 그 영상 목록의 썸네일 이미지를 추가하는 play의 thumbnail이미지로 바꿔준다.

    // 영상을 추가한다.
    // 1. 영상을 저장
    // 2. 첫 영상인 경우, 영상 목록의 thumbnail이미지 변경

    // output: 적절한 json response!
    // (data 객체를 반환해야하면 해당 객체를 domain -> json으로)
    return null;
  }
}
