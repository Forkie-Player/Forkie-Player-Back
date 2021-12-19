package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
final class JsonDeleteRequest {
  @NotNull
  @JsonProperty
  private Long memberId;

  @NotNull
  @JsonProperty
  private Long playlistId;

  @Builder
  JsonDeleteRequest(Long memberId, Long playlistId) {
    this.memberId = memberId;
    this.playlistId = playlistId;
  }
}
