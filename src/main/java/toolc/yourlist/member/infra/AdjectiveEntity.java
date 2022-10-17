package toolc.yourlist.member.infra;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adjective")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdjectiveEntity extends BaseEntity {
  private String content;
}
