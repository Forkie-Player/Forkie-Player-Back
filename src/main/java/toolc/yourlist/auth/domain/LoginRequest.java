package toolc.yourlist.auth.domain;

import lombok.Getter;

@Getter
class LoginRequest {
  private final LoginId loginId;
  private final Password password;

  public LoginRequest(String loginId, String password) {
    this.loginId = new LoginId(loginId);
    this.password = new Password(password);
  }

}
