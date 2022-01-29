package toolc.yourlist.member.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

import java.time.Period;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class MemberAuthProvider {

  private final TokenProvider tokenProvider;
  private final TokenReader tokenReader;
  private final AllMember allMember;

  Either<String, String> registerMember(LoginId loginId, Password password) {
    if (allMember.isNotExistByLoginId(loginId)) {
      return left("Already register Member");
    } else {
      allMember.registerMember(loginId, password);
      return right("Success register new Member");
    }
  }


  Either<String, Token> getMemberToken(LoginId loginId, Password password, boolean isPC) {
    Long id = allMember.findIdByLoginId(loginId);
    Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);
    return right(tokenProvider.makeToken(id, refreshTokenExpiration));
  }

  Either<String, Token> reissueToken(String accessToken, String refreshToken, boolean isPC) {
    Long id = tokenReader.getId(accessToken);
    if (allMember.isNotExistById(id)) {
      throw new IllegalArgumentException();
    }

    Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);

    return right(tokenProvider.makeToken(id, refreshTokenExpiration));
  }
}
