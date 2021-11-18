package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.ResponseBody;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class AuthApi {

  private final LoginRequestMapperFromJson loginRequestMapperFromJson;

  @PostMapping("/api/login")
  public ResponseEntity<?> login(@RequestBody JsonLoginRequest request) {
    ResponseBody responseBody = new ResponseBody(OK.value(), "로그인 성공", "fd");
    return ResponseEntity.ok(responseBody);
  }
}
