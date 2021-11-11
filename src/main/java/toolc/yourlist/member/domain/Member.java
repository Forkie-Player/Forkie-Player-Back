package toolc.yourlist.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
  private String loginId;

  private String password;

  public Member(String loginId, String password) {
    this.loginId = loginId;
    this.password = password;
  }
}
