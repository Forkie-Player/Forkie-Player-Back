package toolc.yourlist.play.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Playlist {
  private Long id;
  private String thumbnail;

  @Builder
  public Playlist(Long id, String thumbnail) {
    this.id = id;
    this.thumbnail = thumbnail;
  }
}
