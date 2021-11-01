package toolc.yourlist.auth.domain;

import lombok.Getter;

@Getter
class LoginRequest {
  private final LoginId loginId;
  private final Password password;
  private final Device device;

  public LoginRequest(String loginId, String password, Device device) {
    this.loginId = new LoginId(loginId);
    this.password = new Password(password);
    this.device = device;
  }

  enum Device {
    PC, APP
  }
}
