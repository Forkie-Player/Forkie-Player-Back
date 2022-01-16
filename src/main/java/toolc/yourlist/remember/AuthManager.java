package toolc.yourlist.remember;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
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
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";
    JwtParser jwtParser =
      Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key))).build();
    String id = jwtParser.parseClaimsJws(accessToken).getBody().getSubject();

    if (!visitorsStorage.containsKey(Long.parseLong(id))) {
      //todo :: usecase에는 없다. 하지만 서버 작동 중 문제가 생겨서 발생했을 가능성은? -> 예외로?
      throw new IllegalArgumentException();
    }

    Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);

    return right(tokenProvider.makeToken(id, refreshTokenExpiration));
  }
}
