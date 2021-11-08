package toolc.yourlist.auth.domain.request;

import lombok.Getter;

@Getter
public class LoginRequest {
  private final LoginId2 loginId;
  private final Password password;
  private final Device device;

  public LoginRequest(String loginId, String password, Device device) {
    this.loginId = new LoginId2(loginId);
    this.password = new Password(password);
    this.device = device;
  }

  public enum Device {
    PC, APP
  }
}
