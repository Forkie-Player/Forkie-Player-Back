package toolc.yourlist.auth.domain.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class LoginRequest {
  private final LoginId loginId;
  private final Password password;
  private final Device device;

  public LoginRequest(LoginId loginId, Password password, Device device) {
    this.loginId = loginId;
    this.password = password;
    this.device = device;
  }

  public enum Device {
    PC, APP
  }
}