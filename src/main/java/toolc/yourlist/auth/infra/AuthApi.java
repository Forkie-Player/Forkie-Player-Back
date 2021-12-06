package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.auth.domain.MemberLogin;
import toolc.yourlist.auth.domain.NonMemberLogin;
import toolc.yourlist.common.ResponseBody;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class AuthApi {

  private final RealLoginRequestMapperFromJson realLoginRequestMapperFromJson;
  private final MemberLogin memberLogin;
  private final NonLoginRequestMapperFromJson nonLoginRequestMapperFromJson;
  private final NonMemberLogin nonMemberLogin;
  private final TokenFormatter tokenFormatter;

  @PostMapping("/api/login/real")
  public ResponseEntity<?> login(@RequestBody JsonRealLoginRequest request) {
    var loginResult =
      memberLogin.login(realLoginRequestMapperFromJson.mapper(request));

    if (loginResult.isLeft()) {
      return ResponseEntity.badRequest().body(loginResult.getLeft());
    }
    if (loginResult.isRight()) {
      ResponseBody responseBody = new ResponseBody(OK.value(), "회원 로그인 성공",
        tokenFormatter.toJwtFromToken(loginResult.get()));

      return ResponseEntity.ok(responseBody);
    }

    throw new InternalError();
  }

  @PostMapping("/api/login/non")
  public ResponseEntity<?> login(@RequestBody JsonNonLoginRequest request) {

    ResponseBody responseBody = new ResponseBody(
      OK.value(), "비회원 로그인 성공",
      tokenFormatter.toJwtFromToken(nonMemberLogin.login(nonLoginRequestMapperFromJson.mapper(request))));

    return ResponseEntity.ok(responseBody);
  }
}
