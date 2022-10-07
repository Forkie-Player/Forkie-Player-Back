package toolc.yourlist.member.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class MemberEntity extends BaseEntity {
  private String loginId;
  private String password;
  private String nickname;

  @Enumerated(value = EnumType.STRING)
  @Column(columnDefinition = "varchar(255) default LOCAL")
  private Provider provider = Provider.LOCAL;

  @Builder
  public MemberEntity(String loginId, String password, String nickname, Provider provider) {
    this.loginId = loginId;
    this.password = password;
    this.nickname = nickname;
    this.provider = provider;
  }
}