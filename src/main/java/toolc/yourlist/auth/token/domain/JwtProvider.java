package toolc.yourlist.auth.token.domain;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.AuthExpiration;
import toolc.yourlist.auth.domain.Token;
import toolc.yourlist.auth.domain.TokenProvider;
import toolc.yourlist.auth.infra.JwtSetConfig;

import java.time.Instant;
import java.util.Date;

@RequiredArgsConstructor
public class JwtProvider implements TokenProvider {

  private final JwtSetConfig jwtSetConfig;
  private final RefreshTokenStorage refreshTokenStorage;


  public Token create(Long id, AuthExpiration authExpiration, String tokenSavedNamePrefix) {
    Token newToken = new Token(toJwtFromAccessToken(id, authExpiration.accessTokenExpiration()),
      toJwtFromRefreshToken(authExpiration.refreshTokenValidExpiration()));
    refreshTokenStorage.save(tokenSavedNamePrefix + id, newToken.refreshToken());
    return newToken;
  }

  private String toJwtFromAccessToken(Long id, Instant expiration) {
    return Jwts.builder()
      .setSubject(id.toString())
      .setExpiration(Date.from(expiration))
      .signWith(jwtSetConfig.key(), jwtSetConfig.signatureAlgorithm())
      .compact();
  }

  private String toJwtFromRefreshToken(Instant expiration) {
    return Jwts.builder()
      .setExpiration(Date.from(expiration))
      .signWith(jwtSetConfig.key(), jwtSetConfig.signatureAlgorithm())
      .compact();
  }
}

