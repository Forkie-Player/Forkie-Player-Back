package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Playlist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record PlaylistJson(
  @NotNull Long id,
  @NotBlank String thumbnail,
  @NotBlank String title
) {
  public PlaylistJson(Playlist playlist) {
    this(playlist.id(), playlist.thumbnail(), playlist.title());
  }
}

