package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toolc.yourlist.member.domain.VisitorAuthProvider;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApi {

  private final VisitorAuthProvider visitorAuthProvider;
  private final RequestMapperFromJson requestMapperFromJson;

  @PostMapping("/auth/signup/visitor")
  public ResponseEntity<?> signup(@RequestBody JsonVisitorSignUpRequest uuid) {
    var signUpRequest = requestMapperFromJson.mapper(uuid);
    visitorAuthProvider.registerVisitor(signUpRequest);

    return ResponseEntity.ok("good");
  }

  @GetMapping("/auth")
  public ResponseEntity<?> getUserAuth() {
    return ResponseEntity.ok("hello");
  }
}
