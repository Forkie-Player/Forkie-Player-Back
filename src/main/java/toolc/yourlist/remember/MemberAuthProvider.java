package toolc.yourlist.remember;

import io.vavr.control.Either;

import java.util.HashMap;
import java.util.Map;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

public class MemberAuthProvider {

  Map<Long, String> memberStorage = new HashMap<>();
  Long id = 1L;

  Either<String, String> registerMember(LoginId loginId, Password password) {
    if (memberStorage.containsValue(loginId.raw())) {
      return left("Already register Member");
    } else {
      memberStorage.put(id++, loginId.raw());
      return right(loginId.raw());
    }
  }
}
