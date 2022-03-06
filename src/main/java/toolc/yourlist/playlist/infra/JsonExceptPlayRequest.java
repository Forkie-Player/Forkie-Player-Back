package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotNull;

record JsonExceptPlayRequest(
  @NotNull Long playlistId,
  @NotNull Long playId) {
}
