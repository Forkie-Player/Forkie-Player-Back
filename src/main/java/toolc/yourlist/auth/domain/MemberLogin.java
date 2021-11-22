package toolc.yourlist.auth.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberLogin {
  private final AllMember allMember;
  private final AccessTokenCreator accessTokenCreator;
  private final RefreshTokenCreator refreshTokenCreator;
  private final CheckPassword checkPassword;

  public Either<String, Token> login(LoginRequest request) {
    Member savedMember = allMember.findByLoginId(request.loginId().raw());

    if(checkPassword.check(request.password(), savedMember)) {
      return Either.right(new Token(accessTokenCreator.create(request.loginId()),
        refreshTokenCreator.create(request.device())));
    }
    return Either.left("wrong password");
  }
}

