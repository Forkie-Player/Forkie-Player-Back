package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotNull;

record JsonReadAllPlaysRequest(
  @NotNull Long memberId,
  @NotNull Long playlistId
) {
}
