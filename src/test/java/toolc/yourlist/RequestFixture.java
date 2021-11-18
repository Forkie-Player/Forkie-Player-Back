package toolc.yourlist;

import toolc.yourlist.playlist.domain.SaveRequest;
import toolc.yourlist.playlist.infra.JsonSaveRequest;

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
