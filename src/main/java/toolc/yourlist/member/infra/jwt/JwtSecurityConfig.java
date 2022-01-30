package toolc.yourlist.member.infra.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import toolc.yourlist.member.infra.jwt.filter.ExceptionHandlerFilter;
import toolc.yourlist.member.infra.jwt.filter.JwtFilter;
import toolc.yourlist.member.infra.jwt.filter.JwtResolver;

@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,
	HttpSecurity> {

  private final JwtResolver jwtResolver;

  @Override
  public void configure(HttpSecurity http) {
    JwtFilter customFilter = new JwtFilter(jwtResolver);
    ExceptionHandlerFilter exceptionHandlerFilter = new ExceptionHandlerFilter();
    http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    http.addFilterBefore(exceptionHandlerFilter, JwtFilter.class);
  }
}
