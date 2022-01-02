package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class LoginRequest {
  private final LoginId loginId;
  private final Password password;
  private final boolean isPC;

  public LoginRequest(LoginId loginId, Password password, boolean isPC) {
    this.loginId = loginId;
    this.password = password;
    this.isPC = isPC;
  }

}
