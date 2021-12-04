package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class LoginRequest {
  private final LoginId loginId;
  private final Password password;
  private final Device device;

  public LoginRequest(LoginId loginId, Password password, Device device) {
    this.loginId = loginId;
    this.password = password;
    this.device = device;
  }

}
