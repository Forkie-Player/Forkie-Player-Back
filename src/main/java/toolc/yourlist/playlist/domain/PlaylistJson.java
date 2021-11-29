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

  public PlaylistJson(PlaylistWithThumbnail playlist) {
    this.id = playlist.id();
    this.thumbnail = playlist.thumbnail();
    this.title = playlist.title();
  }
}

