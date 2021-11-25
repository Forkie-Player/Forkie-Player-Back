package toolc.yourlist.auth.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static io.vavr.control.Either.*;

@RequiredArgsConstructor
@Component
public class MemberLogin {
  private final AllMember allMember;
  private final AccessTokenCreator accessTokenCreator;
  private final RefreshTokenCreator refreshTokenCreator;
  private final CheckPassword checkPassword;

  public Either<String, Token> login(LoginRequest request) {
    Member savedMember = allMember.findByLoginId(request.loginId().raw());

    if (checkPassword.check(request.password(), savedMember)) {
      return right(new Token(accessTokenCreator.create(request.loginId()),
        refreshTokenCreator.create(request.device())));
    }
    return left("wrong password");
  }
}
