package toolc.yourlist.auth.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
class JsonReissueRequest {
  @NotEmpty
  @JsonProperty
  private String accessToken;

  @NotEmpty
  @JsonProperty
  private String refreshToken;

  @NotEmpty
  @JsonProperty
  private boolean isPC;


}
