package toolc.yourlist.remember;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RequiredArgsConstructor
public class TokenProvider {

  private final TokenSecretKey tokenSecretKey;

  Token makeToken(String id, Period refreshTokenExpiration){

    final var accessToken = Jwts.builder()
      .setSubject(id)
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(30, ChronoUnit.MINUTES)))
      .signWith(tokenSecretKey.secretKey())
      .compact();

    final var newRefreshToken = Jwts.builder()
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(refreshTokenExpiration)))
      .signWith(tokenSecretKey.secretKey())
      .compact();

    return new Token(accessToken, newRefreshToken);
  }
}