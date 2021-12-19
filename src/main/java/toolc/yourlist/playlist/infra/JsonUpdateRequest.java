package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
final class JsonUpdateRequest {
  @NotNull
  @JsonProperty
  private Long memberId;

  @NotNull
  @JsonProperty
  private Long playlistId;

  @NotBlank
  @JsonProperty
  private String title;

  @Builder
  JsonUpdateRequest(Long memberId, Long playlistId, String title) {
    this.memberId = memberId;
    this.playlistId = playlistId;
    this.title = title;
  }
}
