package toolc.yourlist.playlist.infra;

import lombok.*;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "playlist")
public class PlaylistEntity extends BaseEntity {
  private Long memberId;
  @Setter
  private String title;

  @Builder
  public PlaylistEntity(Long memberId, String title) {
    this.memberId = memberId;
    this.title = title;
  }
}

