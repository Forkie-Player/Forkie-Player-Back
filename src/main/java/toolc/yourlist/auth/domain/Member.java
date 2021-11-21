package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Member {
  private String loginId;
  private String password;


  public Member(String loginId, String password) {
    this.loginId = loginId;
    this.password = password;
  }
}
