package toolc.yourlist.auth.infra;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@JsonDeserialize(as = JsonLoginRequest.class)
public class JsonLoginRequest {

  @NotEmpty
  private String loginId;

  @NotEmpty
  private String password;

  @NotNull
  private boolean isPC;

  public JsonLoginRequest(String loginId, String password, boolean isPC) {
    this.loginId = loginId;
    this.password = password;
    this.isPC = isPC;
  }
}
