package toolc.yourlist.auth.infra;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class JwtSetConfig {
  @Value("${jwt.secretKey}")
  private String secretKey;

  private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

}
