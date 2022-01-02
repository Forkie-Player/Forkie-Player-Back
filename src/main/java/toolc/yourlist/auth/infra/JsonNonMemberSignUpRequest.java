package toolc.yourlist.auth.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class JsonNonMemberSignUpRequest {

  @NotEmpty
  @JsonProperty
  private String deviceId;

}


