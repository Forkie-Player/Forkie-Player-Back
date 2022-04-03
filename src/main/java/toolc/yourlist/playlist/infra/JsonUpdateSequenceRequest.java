package toolc.yourlist.playlist.infra;

import javax.validation.constraints.NotNull;
import java.util.List;

record JsonUpdateSequenceRequest(
  @NotNull Long playlistId,
  @NotNull List<JsonPlaySequence> list) {
}
