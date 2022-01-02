package toolc.yourlist.auth.infra;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import toolc.yourlist.auth.domain.PasswordEncoder;

public class PasswordEncoderSpringAdapter implements PasswordEncoder {

  private final org.springframework.security.crypto.password.PasswordEncoder springEncoder
    = PasswordEncoderFactories.createDelegatingPasswordEncoder();

  @Override
  public String encode(String raw) {
    return springEncoder.encode(raw);
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return springEncoder.matches(rawPassword, encodedPassword);
  }
}