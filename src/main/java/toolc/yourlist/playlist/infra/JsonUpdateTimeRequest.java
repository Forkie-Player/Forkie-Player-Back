package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotNull;

record JsonUpdateTimeRequest(
  @NotNull Long playlistId,
  @NotNull Long playId,
  @NotNull Long startTime,
  @NotNull Long endTime
) {
}
