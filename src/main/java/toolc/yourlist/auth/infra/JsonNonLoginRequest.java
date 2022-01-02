package toolc.yourlist.auth.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class JsonNonLoginRequest {

  @NotEmpty
  @JsonProperty
  private String deviceId;

  @NotNull
  @JsonProperty
  private boolean isPC;

}
