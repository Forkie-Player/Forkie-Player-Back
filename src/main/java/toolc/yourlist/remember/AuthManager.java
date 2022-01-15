package toolc.yourlist.remember;

import io.vavr.control.Either;

import java.util.HashMap;
import java.util.Map;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

public class AuthManager {

  Map<String, Long> visitorsStorage = new HashMap<>();
  Long id = 1L;

  void registerVisitor(String uuid) {
    if (visitorsStorage.containsKey(uuid)) throw new IllegalArgumentException();
    visitorsStorage.put(uuid, id++);
  }

  Either<String, Token> getVisitorToken(String uuid, boolean isPc) {
    if (visitorsStorage.containsKey(uuid)) {
      return right(new Token("accessToken", "refreshToken"));
    } else return left("등록되어 있지 않은 방문자 입니다.");
  }

}
