package toolc.yourlist.play.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class PlaylistJson {
  @JsonProperty
  private Long id;
  @JsonProperty
  private String thumbnail;

  @Builder
  public PlaylistJson(Long id, String thumbnail) {
    this.id = id;
    this.thumbnail = thumbnail;
  }
}
