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

  @PostMapping("/auth/signup/visitor")
  public ResponseEntity<?> signup(@RequestBody String uuid){
    System.out.println(uuid);
    visitorAuthProvider.registerVisitor(uuid);

    return ResponseEntity.ok("good");
  }

  @GetMapping("/auth")
  public ResponseEntity<?> getUserAuth(){
    return ResponseEntity.ok("hello");
  }
}
