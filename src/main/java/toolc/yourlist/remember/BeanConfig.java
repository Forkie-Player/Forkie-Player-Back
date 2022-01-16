package toolc.yourlist.remember;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  TokenSecretKey tokenSecretKey() {
    return new TokenSecretKey();
  }

  @Bean
  TokenProvider tokenProvider(TokenSecretKey tokenSecretKey) {
    return new TokenProvider(tokenSecretKey);
  }

  @Bean
  TokenReader tokenReader(TokenSecretKey tokenSecretKey) {
    return new TokenReader(tokenSecretKey);
  }

  @Bean
  AuthManager authManager(TokenProvider tokenProvider, TokenReader tokenReader) {
    return new AuthManager(tokenProvider, tokenReader);
  }
}
