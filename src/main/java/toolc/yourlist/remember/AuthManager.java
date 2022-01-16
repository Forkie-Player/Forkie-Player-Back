package toolc.yourlist.remember;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class AuthManager {

  private final TokenProvider tokenProvider;
  private final TokenReader tokenReader;

  Map<Long, String> visitorsStorage = new HashMap<>();
  Long id = 1L;

  String findIdByUUID(String uuid) {
    return visitorsStorage.entrySet()
      .stream()
      .filter(enyty -> enyty.getValue().equals(uuid))
      .map(Map.Entry::getKey)
      .findFirst()
      .get().toString();
  }

  void registerVisitor(String uuid) {
    if (visitorsStorage.containsValue(uuid)) throw new IllegalArgumentException();
    visitorsStorage.put(id++, uuid);
  }

  Either<String, Token> getVisitorToken(String uuid, boolean isPC) {
    if (visitorsStorage.containsValue(uuid)) {
      String id = findIdByUUID(uuid);
      Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);

      return right(tokenProvider.makeToken(id, refreshTokenExpiration));
    } else return left("등록되어 있지 않은 방문자 입니다.");
  }

  Either<String, Token> reissueToken(String accessToken, String refreshToken, boolean isPC) {
    String id = tokenReader.getId(accessToken);
    if (!visitorsStorage.containsKey(Long.parseLong(id))) {
      // todo :: usecase에는 없다. 하지만 서버 작동 중 문제가 생겨서 발생했을 가능성은? -> 예외로?
      throw new IllegalArgumentException();
    }

    Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);

    return right(tokenProvider.makeToken(id, refreshTokenExpiration));
  }
}

