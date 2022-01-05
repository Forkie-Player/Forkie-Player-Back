package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import toolc.yourlist.playlist.domain.Playlist;

record PlaylistJson(
  @JsonProperty Long id,
  @JsonProperty String thumbnail,
  @JsonProperty String title
) {
  public PlaylistJson(Playlist playlist) {
    this(playlist.id(), playlist.thumbnail(), playlist.title());
  }
}

