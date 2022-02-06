package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.member.domain.MemberAuthProvider;
import toolc.yourlist.member.domain.VisitorAuthProvider;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApi {

  private final VisitorAuthProvider visitorAuthProvider;
  private final MemberAuthProvider memberAuthProvider;
  private final RequestMapperFromJson requestMapperFromJson;

  @PostMapping("/auth/signup/visitor")
  public ResponseEntity<?> signup(@RequestBody JsonVisitorSignUpAndLoginRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = visitorAuthProvider.registerVisitor(request);
    if (result.isLeft()) {
      return JsonResponse.failForBadRequest(result.getLeft());
    }
    return JsonResponse.okWithData(result.get(), "Successful registration of visitor");
  }

  @PostMapping("/auth/login/visitor")
  public ResponseEntity<?> login(@RequestBody JsonVisitorSignUpAndLoginRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = visitorAuthProvider.getVisitorToken(request.uuid(), request.isPC());
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
    return JsonResponse.okWithData(result.get(), "Successful registration of member");
  }
}
