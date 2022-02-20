package toolc.yourlist.member.infra.jwt;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class JwtToken implements TokenSerializer {

  private final TokenSecretKey tokenSecretKey;

  @Override
  public Token makeToken(Long id, Instant accessTokenExpiration, Instant refreshTokenExpiration
    , UserType userType) {

    Map<String, Object> payloads = new HashMap<>();
    payloads.put("Id", id);
    payloads.put("UserType", userType);
    final var accessToken = Jwts.builder()
      .setClaims(payloads)
      .setExpiration(Date.from(accessTokenExpiration))
      .signWith(tokenSecretKey.secretKey())
      .compact();

    final var refreshToken = Jwts.builder()
      .setExpiration(Date.from(refreshTokenExpiration))
      .signWith(tokenSecretKey.secretKey())
      .compact();

    return new Token(accessToken, refreshToken);
  }
}
