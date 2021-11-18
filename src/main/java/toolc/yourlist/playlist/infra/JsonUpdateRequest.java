package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class JsonUpdateRequest {
  @NotNull
  @JsonProperty
  private Long playlistId;
  @NotBlank
  @JsonProperty
  private String title;
}
