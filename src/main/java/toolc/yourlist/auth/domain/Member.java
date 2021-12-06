package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Member {
  private final String loginId;
  private final String password;

  public Member(String loginId, String password) {
    this.loginId = loginId;
    this.password = password;
  }
}
