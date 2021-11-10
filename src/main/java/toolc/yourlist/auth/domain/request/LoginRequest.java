package toolc.yourlist.auth.domain.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class LoginRequest {
  private final LoginId2 loginId;
  private final Password2 password;
  private final Device device;

  public LoginRequest(LoginId2 loginId, Password2 password, Device device) {
    this.loginId = loginId;
    this.password = password;
    this.device = device;
  }

  public enum Device {
    PC, APP
  }
}
