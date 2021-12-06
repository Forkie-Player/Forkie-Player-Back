package toolc.yourlist.auth.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.token.domain.Token;
import toolc.yourlist.auth.token.domain.TokenMaterialMaker;
import toolc.yourlist.auth.token.domain.TokenProvider;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class MemberLogin {
  private final AllMember allMember;
  private final TokenMaterialMaker tokenMaterialMaker;
  private final TokenProvider tokenProvider;
  private final CheckPassword checkPassword;

  public Either<String, Token> login(LoginRequest request) {
    Member savedMember = allMember.findByLoginId(request.loginId().raw());

    if (checkPassword.check(request.password(), savedMember)) {
      return right(tokenProvider.create(tokenMaterialMaker.toTokenMaterial(request)));
    }
    return left("wrong password");
  }
}
