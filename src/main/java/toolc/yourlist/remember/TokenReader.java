package toolc.yourlist.remember;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

class TokenReader {

  private final JwtParser jwtParser;

  TokenReader(TokenSecretKey tokenSecretKey) {
    this.jwtParser = Jwts.parserBuilder().setSigningKey(tokenSecretKey.secretKey()).build();
  }


  Long getId(String accessToken) {
    return Long.parseLong(jwtParser.parseClaimsJws(accessToken).getBody().getSubject());
  }
}