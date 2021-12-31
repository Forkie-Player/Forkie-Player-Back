package toolc.yourlist.common.infra;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.*;

class JsonResponseTest {

  @Test
  void 성공_데이터O() {
    assertThat(JsonResponse.okWithData(123, "success"),
      is(ResponseEntity.ok(ResponseBody.builder()
        .status(OK.value())
        .message("success")
        .data(123)
        .build())));
  }

  @Test
  void 성공_데이터X() {
    assertThat(JsonResponse.ok("success"),
      is(ResponseEntity.ok(ResponseBody.builder()
        .status(OK.value())
        .message("success")
        .data(null)
        .build())));
  }

  @Test
  void 실패() {
    assertThat(JsonResponse.fail(new Exception("exception Message")),
      is(ResponseEntity.internalServerError().body(ResponseBody.builder()
        .status(INTERNAL_SERVER_ERROR.value())
        .message("exception Message")
        .data(null)
        .build())));
  }

  @Test
  void 실패_BadRequest() {
    assertThat(JsonResponse.failForBadRequest("bad Request Message"),
      is(ResponseEntity.badRequest().body(ResponseBody.builder()
        .status(BAD_REQUEST.value())
        .message("bad Request Message")
        .data(null)
        .build())));
  }
}