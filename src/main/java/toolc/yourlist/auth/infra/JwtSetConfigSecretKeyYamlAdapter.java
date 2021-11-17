package toolc.yourlist.auth.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtSetConfigSecretKeyYamlAdapter {
  @Value("${jwt.secretKey}")
  String secretKey;

  public JwtSetConfig toJwtSetConfig() {
    return new JwtSetConfig(secretKey);
  }
}
