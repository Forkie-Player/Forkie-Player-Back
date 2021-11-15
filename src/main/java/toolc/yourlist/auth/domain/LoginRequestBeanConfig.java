package toolc.yourlist.auth.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginRequestBeanConfig {

  @Bean
  LoginIdFactory loginIdFactory() {
    return new LoginIdFactory(new All());
  }

  @Bean
  PasswordFactory passwordFactory() {
    return new PasswordFactory(new AllPasswordPolicy());
  }


  CurrentTime currentTime = new CurrentTime();

  @Bean
  AccessTokenCreator accessTokenCreator() {
    return new AccessTokenCreator(currentTime);
  }

  @Bean
  RefreshTokenCreator refreshTokenCreator() {
    return new RefreshTokenCreator(currentTime);
  }
}
