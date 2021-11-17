package toolc.yourlist.auth.infra;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;

@Getter
public class JwtSetConfig {
  String secretKey;
  SignatureAlgorithm signatureAlgorithm;

  public JwtSetConfig(String secretKey) {
    this.secretKey = secretKey;
    this.signatureAlgorithm = SignatureAlgorithm.HS512;
  }
}
