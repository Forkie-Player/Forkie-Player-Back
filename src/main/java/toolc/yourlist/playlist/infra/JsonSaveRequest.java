package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record JsonSaveRequest(
  @NotNull Long memberId,
  @NotBlank String title
) {
}
