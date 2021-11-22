package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import toolc.yourlist.auth.domain.PasswordEncoder;

public class PasswordEncoderAdapter implements PasswordEncoder {

  private org.springframework.security.crypto.password.PasswordEncoder springEncoder
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
