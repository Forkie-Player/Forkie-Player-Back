package toolc.yourlist.playlist.domain;

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
  @JsonProperty
  private String title;

  @Builder
  public PlaylistJson(Long id, String thumbnail, String title) {
    this.id = id;
    this.thumbnail = thumbnail;
    this.title = title;
  }
}

