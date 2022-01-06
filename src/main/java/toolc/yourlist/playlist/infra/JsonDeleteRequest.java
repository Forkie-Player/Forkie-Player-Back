package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

record JsonDeleteRequest(
  @NotNull @JsonProperty Long memberId,
  @NotNull @JsonProperty Long playlistId
) {
}
