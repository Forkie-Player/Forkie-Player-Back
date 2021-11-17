package toolc.yourlist.auth.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.auth.domain.*;

@Configuration
public class BeanConfig {

  @Bean
  LoginIdFactory loginIdFactory() {
    return new LoginIdFactory(new All());
  }

  @Bean
  PasswordFactory passwordFactory() {
    return new PasswordFactory(new AllPasswordPolicy());
  }

  @Bean
  LoginRequestMapperFromJson loginRequestMapperFromJson() {
    return new LoginRequestMapperFromJson(loginIdFactory(), passwordFactory());
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

  @Autowired
  JwtSetConfigSecretKeyYamlAdapter jwtSetConfigSecretKeyYamlAdapter;

  @Bean
  TokenFormatter tokenFormatter() {
    return new TokenFormatter(jwtSetConfigSecretKeyYamlAdapter.toJwtSetConfig());
  }
}
