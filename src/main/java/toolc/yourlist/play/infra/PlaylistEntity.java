package toolc.yourlist.play.infra;

import lombok.*;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@Table(name = "playlist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PlaylistEntity extends BaseEntity {
  private Long memberId;
  private String title;

  @Builder
  public PlaylistEntity(Long memberId, String title) {
    this.memberId = memberId;
    this.title = title;
  }
}

