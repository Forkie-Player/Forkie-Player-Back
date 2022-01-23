package toolc.yourlist.member.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class MemberEntity extends BaseEntity {
  private String loginId;
  private boolean isMember;
  private String password;

  @Builder
  public MemberEntity(String loginId, String password, boolean isMember) {
    this.loginId = loginId;
    this.isMember = isMember;
    this.password = password;
  }
}