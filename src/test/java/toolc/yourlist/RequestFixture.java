package toolc.yourlist;

import toolc.yourlist.play.domain.SaveRequest;
import toolc.yourlist.play.infra.JsonSaveRequest;

public class RequestFixture {
  public static JsonSaveRequest.JsonSaveRequestBuilder jsonSaveRequest() {
    return JsonSaveRequest.builder()
      .loginId("loginId")
      .title("title");
  }
  public static SaveRequest.SaveRequestBuilder saveRequest() {
    return SaveRequest.builder()
      .title("title");
  }
}
