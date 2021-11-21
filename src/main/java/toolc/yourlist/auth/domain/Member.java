package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class Member {
  private String loginId;
  private String password;


  public Member(String loginId, String password) {
    this.loginId = loginId;
    this.password = password;
  }
}
