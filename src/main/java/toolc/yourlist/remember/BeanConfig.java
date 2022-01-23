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
  TimeServer timeServer() {
    return new RealTimeServer();
  }

  @Bean
  TokenProvider tokenProvider(TokenSecretKey tokenSecretKey, TimeServer timeServer) {
    return new TokenProvider(tokenSecretKey, timeServer);
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
