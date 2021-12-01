package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import toolc.yourlist.playlist.domain.Playlist;

@Getter
@EqualsAndHashCode
public final class PlaylistJson {
  @JsonProperty
  private Long id;
  @JsonProperty
  private String thumbnail;
  @JsonProperty
  private String title;

  public PlaylistJson(Playlist playlist) {
    this.id = playlist.id();
    this.thumbnail = playlist.thumbnail();
    this.title = playlist.title();
  }
}

