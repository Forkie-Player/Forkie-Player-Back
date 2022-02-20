package toolc.yourlist.member.infra.jwt.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import toolc.yourlist.member.domain.TokenSecretKey;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;

public class JwtResolver {

  private final JwtParser jwtParser;
  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String BEARER_PREFIX = "Bearer ";

  public JwtResolver(TokenSecretKey tokenSecretKey) {
    this.jwtParser = Jwts.parserBuilder().setSigningKey(tokenSecretKey.secretKey()).build();
  }

  public Authentication getAuthentication(String accessToken) {
    Claims claims = jwtParser.parseClaimsJws(accessToken).getBody();
    Collection<? extends GrantedAuthority> authorities = Collections.emptyList();

    UserDetails principal = new User(claims.getSubject(), "", authorities);
    return new UsernamePasswordAuthenticationToken(principal, "", authorities);
  }

  public boolean validateToken(String token) throws Exception {
    jwtParser.parseClaimsJws(token);
    return true;
  }

  public String resolveRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
      return bearerToken.substring(BEARER_PREFIX.length());
    }
    return null;
  }
}
