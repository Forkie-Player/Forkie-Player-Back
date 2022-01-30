package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotNull;

record JsonUpdateTimeRequest(
  @NotNull Long memberId,
  @NotNull Long playId,
  @NotNull Long startTime,
  @NotNull Long endTime
) {
}
