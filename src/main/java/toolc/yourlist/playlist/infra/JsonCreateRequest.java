package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
final class JsonCreateRequest {
  @NotNull
  @JsonProperty
  private Long memberId;
  @NotBlank
  @JsonProperty
  private String title;

  @Builder
  JsonCreateRequest(Long memberId, String title) {
    this.memberId = memberId;
    this.title = title;
  }
}
