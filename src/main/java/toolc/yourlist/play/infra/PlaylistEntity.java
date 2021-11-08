package toolc.yourlist.play.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaylistEntity {
  private Long id;
  private Long memberId;

  @Builder
  public PlaylistEntity(Long id, Long memberId) {
    this.id = id;
    this.memberId = memberId;
  }
}

