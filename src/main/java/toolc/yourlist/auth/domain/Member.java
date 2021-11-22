package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@Getter
public class Member {
  private String loginId;
  private String password;

  public Member(String loginId, String password) {
    this.loginId = loginId;
    this.password = password;
  }
}
