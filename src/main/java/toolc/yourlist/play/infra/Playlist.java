package toolc.yourlist.play.infra;

import lombok.*;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Playlist extends BaseEntity {
  private Long memberId;
  private String title;

  @Builder
  public Playlist(Long memberId, String title) {
    this.memberId = memberId;
    this.title = title;
  }
}

