package toolc.yourlist.member.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import toolc.yourlist.common.infra.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OAuthAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    var responseBody = ResponseBody.builder()
      .status(HttpStatus.UNAUTHORIZED.value())
      .data(null)
      .message(exception.getMessage())
      .build();

    PrintWriter out = response.getWriter();
    out.print(new ObjectMapper().writeValueAsString(responseBody));
    out.flush();
  }
}
