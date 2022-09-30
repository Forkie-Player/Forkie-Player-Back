package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.member.domain.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApi {

  private final VisitorAuthProvider visitorAuthProvider;
  private final MemberAuthProvider memberAuthProvider;
  private final TokenProvider tokenProvider;
  private final VisitorToMemberChanger visitorToMemberChanger;
  private final RequestMapperFromJson requestMapperFromJson;
  private final MemberFinder memberFinder;

  @GetMapping()
  public ResponseEntity<?> getINfo(@Auth AuthenticationUser authenticationUser) {
    return JsonResponse.okWithData(new JsonMemberInfo(memberFinder.getInfoById(authenticationUser.id())), "사용자 정보 조회 성공");
  }

  @PostMapping("/auth/signup/visitor")
  public ResponseEntity<?> signup(@RequestBody JsonVisitorSignUpAndLoginRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = visitorAuthProvider.registerVisitor(request);
    if (result.isLeft()) {
      return JsonResponse.failForBadRequest(result.getLeft());
    }
    return JsonResponse.okWithData(result.get(), "Successful visitor registration");
  }

  @PostMapping("/auth/login/visitor")
  public ResponseEntity<?> login(@RequestBody JsonVisitorSignUpAndLoginRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = visitorAuthProvider.getVisitorToken(request);
    if (result.isLeft()) {
      return JsonResponse.failForBadRequest(result.getLeft());
    }
    return JsonResponse.okWithData(result.get(), "Successful visitor login");
  }

  @PostMapping("/auth/signup/member")
  public ResponseEntity<?> signup(@RequestBody JsonMemberSignUpAndLoginRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = memberAuthProvider.registerMember(request);
    if (result.isLeft()) {
      return JsonResponse.failForBadRequest(result.getLeft());
    }
    return JsonResponse.okWithData(result.get(), "Successful member registration");
  }

  @PostMapping("/auth/login/member")
  public ResponseEntity<?> login(@RequestBody JsonMemberSignUpAndLoginRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = memberAuthProvider.getMemberToken(request);
    if (result.isLeft()) {
      return JsonResponse.failForBadRequest(result.getLeft());
    }
    return JsonResponse.okWithData(result.get(), "Successful member login");
  }

  @PostMapping("/auth/reissue")
  public ResponseEntity<?> reissue(@RequestBody JsonTokenReissueRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = tokenProvider.reissue(request.accessToken(), request.refreshToken(),
      request.isPC());
    return JsonResponse.okWithData(result, "Successful reissue token");
  }

  @PostMapping("/auth/change")
  public ResponseEntity<?> test(@RequestBody JsonVisitorToMemberChangeRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = visitorToMemberChanger.changeToMember(request);
    if (result.isLeft()) {
      return JsonResponse.failForBadRequest(result.getLeft());
    }
    return JsonResponse.okWithData(result.get(), "Successful visitor change to member");
  }
}

