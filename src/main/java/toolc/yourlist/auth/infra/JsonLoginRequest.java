package toolc.yourlist.auth.infra;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonLoginRequest {

  private String loginId;

  private String password;

  private String device;

  public JsonLoginRequest(String loginId, String password, String device) {
    this.loginId = loginId;
    this.password = password;
    this.device = device;
  }
}
