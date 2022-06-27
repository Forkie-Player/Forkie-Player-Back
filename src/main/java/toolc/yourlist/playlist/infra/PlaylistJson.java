package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.PlaylistWithCount;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record PlaylistJson(
  @NotNull Long id,
  @NotBlank String thumbnail,
  @NotBlank String title,
  @NotNull Long playCount
) {
  public PlaylistJson(PlaylistWithCount playlistWithCount) {
    this(
      playlistWithCount.id(),
      playlistWithCount.thumbnail(),
      playlistWithCount.title(),
      playlistWithCount.playCount());
  }

  public PlaylistJson(Playlist playlist) {
    this(
      playlist.id(),
      playlist.thumbnail(),
      playlist.title(),
      0L);
  }
}

