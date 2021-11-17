package toolc.yourlist.auth.infra;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import toolc.yourlist.auth.domain.AccessToken;
import toolc.yourlist.auth.domain.RefreshToken;
import toolc.yourlist.auth.domain.Token;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenFormatter {
  private final SecretKey key;
  private final SignatureAlgorithm signatureAlgorithm;

  public TokenFormatter(JwtSetConfig jwtSetConfig) {
    this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSetConfig.secretKey()));
    this.signatureAlgorithm = jwtSetConfig.signatureAlgorithm();
  }

  public Map<String, String> toJwtFromToken(Token token) {
    Map<String, String> tokenString = new HashMap<String, String>();

    tokenString.put("AccessToken", toJwtFromAccessToken(token.accessToken()));
    tokenString.put("RefreshToken", toJwtFromRefreshToken(token.refreshToken()));

    return tokenString;
  }

  private String toJwtFromAccessToken(AccessToken accessToken) {
    return Jwts.builder()
      .setSubject(accessToken.loginId().raw())
      .setExpiration(Date.from(accessToken.expirationAt()))
      .signWith(key, signatureAlgorithm)
      .compact();
  }

  private String toJwtFromRefreshToken(RefreshToken refreshToken) {
    return Jwts.builder()
      .setExpiration(Date.from(refreshToken.expirationAt()))
      .signWith(key, signatureAlgorithm)
      .compact();
  }
}
