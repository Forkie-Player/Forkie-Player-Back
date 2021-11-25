package toolc.yourlist.playlist.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public final class JsonSaveRequest {
  @NotNull
  @JsonProperty
  private String loginId;
  @NotBlank
  @JsonProperty
  private String title;

  @Builder
  JsonSaveRequest(String loginId, String title) {
    this.loginId = loginId;
    this.title = title;
  }
}
