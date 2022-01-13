package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.auth.domain.MemberLogin;
import toolc.yourlist.auth.domain.NonMemberLogin;
import toolc.yourlist.auth.domain.NonMemberSignUp;
import toolc.yourlist.auth.domain.TokenVerifier;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.common.infra.ResponseBody;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class AuthApi {

  private final RealLoginRequestMapperFromJson realLoginRequestMapperFromJson;
  private final MemberLogin memberLogin;
  private final NonLoginRequestMapperFromJson nonLoginRequestMapperFromJson;
  private final NonMemberLogin nonMemberLogin;
  private final NonMemberSignUpRequestMapperFromJson nonMemberSignUpRequestMapperFromJson;
  private final NonMemberSignUp nonMemberSignUp;

  private final ReissueRequestAdapterFromJson reissueRequestAdapterFromJson;
  private final TokenVerifier tokenVerifier;
  private final TokenToJsonAdapter tokenToJsonAdapter;

  @PostMapping("/api/login/real")
  public ResponseEntity<?> login(@RequestBody JsonRealLoginRequest request) {
    var loginResult =
      memberLogin.login(realLoginRequestMapperFromJson.mapper(request));

    if (loginResult.isLeft()) {
      return ResponseEntity.badRequest().body(loginResult.getLeft());
    }
    if (loginResult.isRight()) {
      ResponseBody responseBody = new ResponseBody(
        OK.value(), "회원 로그인 성공", loginResult.get());
      return ResponseEntity.ok(responseBody);
    }

    throw new InternalError();
  }

  @PostMapping("/api/login/non")
  public ResponseEntity<?> login(@RequestBody JsonNonLoginRequest request) {

    ResponseBody responseBody = new ResponseBody(
      OK.value(), "비회원 로그인 성공",
      tokenToJsonAdapter.toJson(nonMemberLogin.login(nonLoginRequestMapperFromJson.mapper(request))));

    return ResponseEntity.ok(responseBody);
  }

  @PostMapping("api/signup")
  public ResponseEntity<?> signUp(@RequestBody JsonNonMemberSignUpRequest jsonRequest) {
    var request = nonMemberSignUpRequestMapperFromJson.mapper(jsonRequest);

    var result = nonMemberSignUp.singUp(request);
    ResponseBody responseBody = new ResponseBody(
      CREATED.value(), "비회원 등록 성공", null);

    return ResponseEntity.created(null).body(responseBody);
  }

  @PostMapping("api/reissue")
  public ResponseEntity<?> reissue(@RequestBody JsonReissueRequest jsonRequest) {
    var request = reissueRequestAdapterFromJson.mapper(jsonRequest);

    var result = tokenVerifier.reissue(request);
    if (result.isRight()) {
      return JsonResponse.okWithData(tokenToJsonAdapter.toJson(result.get()), "재발급 성공");
    } else
      return ResponseEntity.badRequest().body(result.getLeft());
  }
}
