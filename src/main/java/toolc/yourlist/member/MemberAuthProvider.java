package toolc.yourlist.member;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.loginId.LoginId;
import toolc.yourlist.member.domain.password.Password;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class MemberAuthProvider {

  private final TokenProvider tokenProvider;
  private final TokenReader tokenReader;

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


  Either<String, Token> login(LoginId loginId, Password password, boolean isPC) {
    Long id = findIdByLoginId(loginId);
    Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);
    return right(tokenProvider.makeToken(id, refreshTokenExpiration));
  }

  private Long findIdByLoginId(LoginId loginId) {
    return memberStorage.entrySet()
      .stream()
      .filter(enyty -> enyty.getValue().equals(loginId.raw()))
      .map(Map.Entry::getKey)
      .findFirst()
      .get();
  }

  Either<String, Token> reissueToken(String accessToken, String refreshToken, boolean isPC) {
    Long id = tokenReader.getId(accessToken);
    if (!memberStorage.containsKey(id)) {
      throw new IllegalArgumentException();
    }

    Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);

    return right(tokenProvider.makeToken(id, refreshTokenExpiration));
  }
}
