package toolc.yourlist.play.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class PlaylistJson {
  private Long id;
  private String thumbnail;

  @Builder
  public PlaylistJson(Long id, String thumbnail) {
    this.id = id;
    this.thumbnail = thumbnail;
  }
}
