package toolc.yourlist.play.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class PlaylistJson {
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
