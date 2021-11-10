package toolc.yourlist.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseBody {
  @JsonProperty
  private int status;
  @JsonProperty
  private String message;
  @JsonProperty
  private Object data;

  @Builder
  public ResponseBody(int status, String message, Object data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }
}
