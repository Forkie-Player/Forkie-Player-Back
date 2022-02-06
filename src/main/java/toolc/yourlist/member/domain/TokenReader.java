package toolc.yourlist.member.domain;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.jackson.io.JacksonDeserializer;
import io.jsonwebtoken.lang.Maps;

public class TokenReader {

  private final JwtParser jwtParser;

  public TokenReader(TokenSecretKey tokenSecretKey) {
    this.jwtParser = Jwts.parserBuilder()
      .deserializeJsonWith(new JacksonDeserializer(Maps.of("UserType", UserType.class).build()))
      .setSigningKey(tokenSecretKey.secretKey()).build();
  }


  TokenUserInfo getPayload(String accessToken) {
    Claims body = jwtParser.parseClaimsJws(accessToken).getBody();
    return new TokenUserInfo(body.get("Id", Long.class), body.get("UserType", UserType.class));
  }
}
