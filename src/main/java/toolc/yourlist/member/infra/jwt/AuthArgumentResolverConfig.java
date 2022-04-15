package toolc.yourlist.member.infra.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import toolc.yourlist.member.infra.AuthenticationArgumentResolver;

import java.util.List;


@Configuration
@RequiredArgsConstructor
public class
AuthArgumentResolverConfig implements WebMvcConfigurer {
  private final AuthenticationArgumentResolver authenticationArgumentResolver;

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(authenticationArgumentResolver);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods(
        HttpMethod.GET.name(),
        HttpMethod.HEAD.name(),
        HttpMethod.POST.name(),
        HttpMethod.PUT.name(),
        HttpMethod.DELETE.name()
      );
  }
}
