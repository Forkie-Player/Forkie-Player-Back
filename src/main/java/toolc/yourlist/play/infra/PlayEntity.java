package toolc.yourlist.play.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayEntity {
  private int sequence;
  private String thumbnail;

  @Builder
  public PlayEntity(int sequence, String thumbnail) {
    this.sequence = sequence;
    this.thumbnail = thumbnail;
  }
}
