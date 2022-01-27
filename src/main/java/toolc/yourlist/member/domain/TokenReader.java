package toolc.yourlist.member.domain;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class TokenReader {

  private final JwtParser jwtParser;

  public TokenReader(TokenSecretKey tokenSecretKey) {
    this.jwtParser = Jwts.parserBuilder().setSigningKey(tokenSecretKey.secretKey()).build();
  }


  Long getId(String accessToken) {
    return jwtParser.parseClaimsJws(accessToken).getBody().get("Id", Long.class);
  }
}
