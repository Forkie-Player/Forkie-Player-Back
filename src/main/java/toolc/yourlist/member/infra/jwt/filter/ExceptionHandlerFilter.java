package toolc.yourlist.member.infra.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import toolc.yourlist.member.infra.jwt.InvalidJwtFailResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
      setErrorResponse(HttpStatus.UNAUTHORIZED, response, "잘못된 JWT 서명입니다.");
    } catch (ExpiredJwtException e) {
      setErrorResponse(HttpStatus.BAD_REQUEST, response, "만료된 JWT 토큰입니다.");
    } catch (UnsupportedJwtException e) {
      setErrorResponse(HttpStatus.UNAUTHORIZED, response, "지원되지 않는 JWT 토큰입니다.");
    } catch (IllegalArgumentException e) {
      setErrorResponse(HttpStatus.UNAUTHORIZED, response, "JWT 토큰이 잘못되었습니다.");
    }catch (RuntimeException e) {
      setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, response, "예상치 못한 서버 오류입니다.");
    }
  }

  private void setErrorResponse(HttpStatus status, HttpServletResponse response, String message) throws IOException {
    response.setStatus(status.value());
    response.setContentType("application/json;charset=UTF-8");
    ObjectMapper mapper = new ObjectMapper();
    response.getWriter().write(
      mapper.writeValueAsString(InvalidJwtFailResponse.builder()
        .status(status.value())
        .message(message)
        .build())
    );
  }
}
