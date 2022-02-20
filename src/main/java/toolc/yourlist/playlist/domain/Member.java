package toolc.yourlist.playlist.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Member {
  private Long id;
  private String loginId;
  private String password;
  private boolean isMember;

  @Builder
  public Member(Long id, String loginId, boolean isMember, String password) {
    this.id = id;
    this.loginId = loginId;
    this.isMember = isMember;
    this.password = password;
  }
}
