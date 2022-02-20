package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotNull;

record JsonPlaySequence(
  @NotNull Long playId,
  @NotNull Long sequence) {
}
