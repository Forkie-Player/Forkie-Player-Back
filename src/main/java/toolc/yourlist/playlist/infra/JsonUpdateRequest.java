package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record JsonUpdateRequest(
  @NotNull Long memberId,
  @NotNull Long playlistId,
  @NotBlank String title
) {
}
