package toolc.yourlist.member.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VisitorEntity extends BaseEntity {
  private String uuid;

  @Builder
  public VisitorEntity(String uuid) {
    this.uuid = uuid;
  }
}