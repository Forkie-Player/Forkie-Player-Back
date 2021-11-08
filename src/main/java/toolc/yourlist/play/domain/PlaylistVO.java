package toolc.yourlist.play.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class PlaylistVO {
  private Long id;
  private String thumbnail;

  @Builder
  public PlaylistVO(Long id, String thumbnail) {
    this.id = id;
    this.thumbnail = thumbnail;
  }
}
