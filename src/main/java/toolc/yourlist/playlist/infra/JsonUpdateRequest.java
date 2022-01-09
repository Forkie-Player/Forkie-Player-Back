package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record JsonUpdateRequest(
  @NotNull Long memberId,
  @NotNull Long playlistId,
  @NotBlank String title
) {
}
