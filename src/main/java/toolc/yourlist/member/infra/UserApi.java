package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.member.domain.VisitorAuthProvider;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApi {

  private final VisitorAuthProvider visitorAuthProvider;
  private final RequestMapperFromJson requestMapperFromJson;

  @PostMapping("/auth/signup/visitor")
  public ResponseEntity<?> signup(@RequestBody JsonVisitorSignUpRequest jsonRequest) {
    var request = requestMapperFromJson.mapper(jsonRequest);

    var result = visitorAuthProvider.registerVisitor(request);
    if (result.isLeft()) {
      return JsonResponse.failForBadRequest(result.getLeft());
    }
    return JsonResponse.okWithData(result.get(), "");
  }
}
