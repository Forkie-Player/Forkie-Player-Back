package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.auth.domain.MemberLogin;
import toolc.yourlist.auth.domain.Token;
import toolc.yourlist.common.ResponseBody;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class AuthApi {

  private final LoginRequestMapperFromJson loginRequestMapperFromJson;
  private final MemberLogin memberLogin;

  @PostMapping("/api/login")
  public ResponseEntity<?> login(@RequestBody JsonLoginRequest request) {
    Token loginToken = memberLogin.login(loginRequestMapperFromJson.mapper(request));

    ResponseBody responseBody = new ResponseBody(OK.value(), "로그인 성공", loginToken);
    return ResponseEntity.ok(responseBody);
  }
}
