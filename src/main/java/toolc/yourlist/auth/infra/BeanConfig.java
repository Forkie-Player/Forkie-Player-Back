package toolc.yourlist.auth.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;
import toolc.yourlist.auth.domain.LoginIdFactory;
import toolc.yourlist.auth.domain.PasswordFactory;

@Configuration
public class BeanConfig {

  @Autowired
  private LoginIdFactory loginIdFactory;

  @Autowired
  private PasswordFactory passwordFactory;

  @Bean
  LoginRequestMapperFromJson loginRequestMapperFromJson() {
    return new LoginRequestMapperFromJson(loginIdFactory, passwordFactory);
  }
}
