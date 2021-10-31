package toolc.yourlist.auth.domain;

import lombok.Getter;

public class LoginRequest {
  protected final LoginId loginId;

  public LoginRequest(LoginId loginId) {
    this.loginId = loginId;
  }


  static class LoginId {
    @Getter
    private String id;

    public LoginId(String id) {
      this.id = id;
    }
  }
}
