package toolc.yourlist.member.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

  @GetMapping("api/user/auth")
  public ResponseEntity<?> getUserAuth(){
    return ResponseEntity.ok("hello");
  }
}
