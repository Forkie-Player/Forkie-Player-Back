package toolc.yourlist.member.infra;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Member {
  @EqualsAndHashCode.Exclude
  private final MemberEntity entity;

  private final String loginId;
  private final boolean isMember;
  private final String password;

  public Member(MemberEntity entity) {
    if (entity == null) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }

    this.entity = entity;
    this.loginId = entity.loginId();
    this.isMember = entity.isMember();
    this.password = entity.password();
  }
}
