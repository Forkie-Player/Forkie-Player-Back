package toolc.yourlist.member.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.*;

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
    return new TokenProvider(tokenSecretKey, timeServer, UserType.MEMBER);
  }

  @Bean
  TokenReader tokenReader(TokenSecretKey tokenSecretKey) {
    return new TokenReader(tokenSecretKey);
  }

//  @Bean
//  VisitorAuthProvider authManager(TokenProvider tokenProvider, TokenReader tokenReader) {
//    return new VisitorAuthProvider(tokenProvider, tokenReader);
//  }
}
