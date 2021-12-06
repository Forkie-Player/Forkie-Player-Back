package toolc.yourlist.auth.domain;

import io.vavr.control.Either;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

public class LoginIdCondition {
  public Either<String, LoginId2> check(String loginId) {
    try {
      return right(new LoginId2(loginId));
    } catch (IllegalArgumentException e) {
      return left(e.getMessage());
    }
  }
}
