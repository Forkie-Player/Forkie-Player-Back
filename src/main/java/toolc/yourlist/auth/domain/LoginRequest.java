package toolc.yourlist.auth.domain;

import lombok.Getter;

public class LoginRequest {
  protected final LoginId loginId;
  protected final Password password;

  public LoginRequest(LoginId loginId, Password password) {
    this.loginId = loginId;
    this.password = password;
  }


  static class LoginId {
    @Getter
    private String id;

    public LoginId(String id) {
      LoginIdValidator.validateId(id);
      this.id = id;
    }
  }

  static class Password {
    @Getter
    private String password;

    public Password(String password) {
      this.password = password;
    }
  }
}
