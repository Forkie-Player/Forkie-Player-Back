package toolc.yourlist.member.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class JsonVisitorSignUpAndLoginRequest {

  @NotBlank
  @JsonProperty
  private String uuid;

  @NotBlank
  @JsonProperty
  private Boolean isPC;
}
