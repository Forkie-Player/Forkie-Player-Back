package toolc.yourlist.auth.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class MemberLogin {
  private final AllMember allMember;
  private final TokenProvider tokenProvider;
  private final CheckPassword checkPassword;

  public Either<String, Token> login(LoginRequest request) {
    Member savedMember = allMember.findByLoginId(request.loginId().raw());

    if (checkPassword.check(request.password(), savedMember)) {
      return right(tokenProvider.create(savedMember.id(), request.device()));
    }
    return left("wrong password");
  }
}
