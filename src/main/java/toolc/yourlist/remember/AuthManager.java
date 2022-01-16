package toolc.yourlist.remember;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.vavr.control.Either;

import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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

  Either<String, Token> getVisitorToken(String uuid, boolean isPC) {
    if (visitorsStorage.containsKey(uuid)) {

      String id = visitorsStorage.get(uuid).toString();
      String key =
        "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";

      final var accessToken = Jwts.builder()
        .setSubject(id)
        .setExpiration(Date.from(Instant.ofEpochSecond(1642312459).plus(30, ChronoUnit.MINUTES)))
        .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
        .compact();

      Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);
      final var refreshToken = Jwts.builder()
        .setExpiration(Date.from(Instant.ofEpochSecond(1642312459).plus(refreshTokenExpiration)))
        .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
        .compact();


      return right(new Token(accessToken, refreshToken));
    } else return left("등록되어 있지 않은 방문자 입니다.");
  }

  Either<String, Token> reissueToken(String accessToken, String refreshToken, boolean isPC){
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";
    JwtParser jwtParser =
      Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key))).build();
    String id = jwtParser.parseClaimsJws(accessToken).getBody().getSubject();

    final var newAccessToken = Jwts.builder()
      .setSubject(id)
      .setExpiration(Date.from(Instant.ofEpochSecond(1642312459).plus(30, ChronoUnit.MINUTES)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    Period refreshTokenExpiration = isPC ? Period.ofDays(7) : Period.ofDays(90);
    final var newRefreshToken = Jwts.builder()
      .setExpiration(Date.from(Instant.ofEpochSecond(1642312459).plus(refreshTokenExpiration)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    return right(new Token(newAccessToken, newRefreshToken));
  }
}
