package toolc.yourlist.common.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static toolc.yourlist.common.infra.JsonResponse.fail;
import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;

@RestControllerAdvice
public class CommonExceptionHandler {
  @ExceptionHandler(
    value = {
      ContractViolationException.class,
      MethodArgumentNotValidException.class,
      HttpMessageNotReadableException.class
    }
  )
  public ResponseEntity<?> badRequest(Exception e) {
    return failForBadRequest(e.getMessage());
  }

  @ExceptionHandler({
    RuntimeException.class
  })
  public ResponseEntity<?> serverError(Exception e) {
    return fail(e);
  }
}
