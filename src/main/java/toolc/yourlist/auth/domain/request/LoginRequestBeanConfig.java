package toolc.yourlist.auth.domain.request;

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
}
