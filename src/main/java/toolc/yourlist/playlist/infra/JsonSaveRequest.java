package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

record JsonSaveRequest(
  @NotNull @JsonProperty Long memberId,
  @NotBlank @JsonProperty String title
) {
}
