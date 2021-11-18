package toolc.yourlist.common.infra;

import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class JsonResponse {
  public static ResponseEntity<?> successWithData(Object data, String message) {
    return ResponseEntity.ok(ResponseBody.builder()
      .status(OK.value())
      .message(message)
      .data(data)
      .build());
  }

  public static ResponseEntity<?> success(String message) {
    return successWithData(null, message);
  }

  public static ResponseEntity<?> fail(Exception e) {
    return ResponseEntity.internalServerError().body(
      ResponseBody.builder()
        .status(INTERNAL_SERVER_ERROR.value())
        .message(e.getMessage())
        .data(null)
        .build());
  }

  public static ResponseEntity<?> failForBadRequest(String message) {
    return ResponseEntity.badRequest().body(ResponseBody.builder()
      .status(BAD_REQUEST.value())
      .message(message)
      .data(null)
      .build());
  }
}
