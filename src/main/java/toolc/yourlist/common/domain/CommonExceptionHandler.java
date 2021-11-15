package toolc.yourlist.common.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import toolc.yourlist.common.ResponseBody;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class CommonExceptionHandler {
  @ExceptionHandler(
    value = {
      ContractViolationException.class,
      MethodArgumentNotValidException.class
    }
  )
  public ResponseEntity<?> badRequest(Exception e) {
    ResponseBody responseBody = ResponseBody.builder()
      .status(BAD_REQUEST.value())
      .message(e.getMessage())
      .build();

    return ResponseEntity.badRequest().body(responseBody);
  }

  @ExceptionHandler({
    RuntimeException.class
  })
  public ResponseEntity<?> serverError(Exception e) {
    ResponseBody responseBody = ResponseBody.builder()
      .status(INTERNAL_SERVER_ERROR.value())
      .message(e.getMessage())
      .build();

    return ResponseEntity.internalServerError().body(responseBody);
  }
}
