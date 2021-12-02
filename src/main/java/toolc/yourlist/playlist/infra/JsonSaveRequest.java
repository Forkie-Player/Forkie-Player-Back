package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public final class JsonSaveRequest {
  @NotNull
  @JsonProperty
  private Long memberId;
  @NotBlank
  @JsonProperty
  private String title;

  @Builder
  JsonSaveRequest(Long memberId, String title) {
    this.memberId = memberId;
    this.title = title;
  }
}
