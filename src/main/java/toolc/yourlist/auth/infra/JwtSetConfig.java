package toolc.yourlist.auth.infra;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;

import javax.crypto.SecretKey;

@Getter
public class JwtSetConfig {
  private final SecretKey key;
  private final SignatureAlgorithm signatureAlgorithm;

  public JwtSetConfig(String secretKey) {
    this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    this.signatureAlgorithm = SignatureAlgorithm.HS512;
  }
}
