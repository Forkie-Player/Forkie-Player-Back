package toolc.yourlist.member.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class JsonVisitorSignUpAndLoginRequest {

  @NotBlank
  @JsonProperty
  private String uuid;

  @NotBlank
  @JsonProperty
  private Boolean isPC;
}
