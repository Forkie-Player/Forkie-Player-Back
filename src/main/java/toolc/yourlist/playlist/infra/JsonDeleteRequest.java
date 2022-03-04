package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotNull;

record JsonDeleteRequest(
  @NotNull Long playlistId
) {
}
