package toolc.yourlist.remember;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TokenProvider {

  Token makeToken(String id, Period refreshTokenExpiration){
    String key =
      "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";

    final var accessToken = Jwts.builder()
      .setSubject(id)
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(30, ChronoUnit.MINUTES)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    final var newRefreshToken = Jwts.builder()
      .setExpiration(Date.from(Instant.ofEpochSecond(1642318730).plus(refreshTokenExpiration)))
      .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
      .compact();

    return new Token(accessToken, newRefreshToken);
  }
}
