package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class JsonUpdateRequest {
  @NotBlank
  @JsonProperty
  private String loginId;

  @NotNull
  @JsonProperty
  private Long playlistId;

  @NotBlank
  @JsonProperty
  private String title;

  @Builder
  JsonUpdateRequest(String loginId, Long playlistId, String title) {
    this.loginId = loginId;
    this.playlistId = playlistId;
    this.title = title;
  }
}
