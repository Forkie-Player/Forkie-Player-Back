package toolc.yourlist.auth.token.domain;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.Token;
import toolc.yourlist.auth.domain.TokenProvider;
import toolc.yourlist.auth.infra.JwtSetConfig;

import java.util.Date;

@RequiredArgsConstructor
public class JwtProvider implements TokenProvider {

  private final JwtSetConfig jwtSetConfig;
  private final TokenExpirationConfig tokenExpirationConfig;


  public Token create(Long id, boolean isPC) {
    Device device = isPC ? Device.PC : Device.APP;
    return new Token(toJwtFromAccessToken(id),
      toJwtFromRefreshToken(device));
  }

  private String toJwtFromAccessToken(Long id) {
    return Jwts.builder()
      .setSubject(id.toString())
      .setExpiration(Date.from(tokenExpirationConfig.accessTokenExpirationTime()))
      .signWith(jwtSetConfig.key(), jwtSetConfig.signatureAlgorithm())
      .compact();
  }

  private String toJwtFromRefreshToken(Device device) {
    return Jwts.builder()
      .setExpiration(Date.from(tokenExpirationConfig.refreshTokenExpirationTime(device)))
      .signWith(jwtSetConfig.key(), jwtSetConfig.signatureAlgorithm())
      .compact();
  }
}

