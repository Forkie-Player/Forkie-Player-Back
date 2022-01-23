package toolc.yourlist.remember;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RequiredArgsConstructor
public class TokenProvider {

  private final TokenSecretKey tokenSecretKey;
  private final TimeServer timeServer;

  Token makeToken(Long id, Period refreshTokenExpiration) {

    final var accessToken = Jwts.builder()
      .setSubject(id.toString())
      .setExpiration(Date.from(timeServer.nowTime().plus(30, ChronoUnit.MINUTES).toInstant()))
      .signWith(tokenSecretKey.secretKey())
      .compact();

    final var newRefreshToken = Jwts.builder()
      .setExpiration(Date.from(timeServer.nowTime().plus(refreshTokenExpiration).toInstant()))
      .signWith(tokenSecretKey.secretKey())
      .compact();

    return new Token(accessToken, newRefreshToken);
  }
}

