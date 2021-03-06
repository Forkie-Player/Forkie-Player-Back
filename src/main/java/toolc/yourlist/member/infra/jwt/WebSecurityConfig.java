package toolc.yourlist.member.infra.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;
import toolc.yourlist.member.infra.CustomOidcService;
import toolc.yourlist.member.infra.OAuthAuthenticationFailureHandler;
import toolc.yourlist.member.infra.OAuthAuthenticationSuccessHandler;
import toolc.yourlist.member.infra.jwt.filter.JwtResolver;
import toolc.yourlist.member.infra.jwt.handler.JwtAccessDeniedHandler;
import toolc.yourlist.member.infra.jwt.handler.JwtAuthenticationEntryPoint;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtResolver jwtResolver;
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
  private final CustomOidcService customOidcService;
  private final OAuthAuthenticationSuccessHandler oAuthAuthenticationSuccessHandler;
  private final OAuthAuthenticationFailureHandler oAuthAuthenticationFailureHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()

      .exceptionHandling()
      .authenticationEntryPoint(jwtAuthenticationEntryPoint)
      .accessDeniedHandler(jwtAccessDeniedHandler)

      .and()
      .headers()
      .frameOptions()
      .sameOrigin()

      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

      .and()
      .authorizeRequests()
      .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
      .antMatchers("/api/").authenticated()
      .antMatchers("/api/user/auth/**").permitAll()
      .antMatchers("/api/**").authenticated()
      .and()
      .apply(new JwtSecurityConfig(jwtResolver))

      .and()
      .oauth2Login()
      .authorizationEndpoint()
      .baseUri("/v1/oauth2/authorization")
      .and()
      .userInfoEndpoint()
      .oidcUserService(customOidcService)
      .and()
      .successHandler(oAuthAuthenticationSuccessHandler)
      .failureHandler(oAuthAuthenticationFailureHandler);
  }
}