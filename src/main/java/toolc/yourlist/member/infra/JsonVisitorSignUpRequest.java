package toolc.yourlist.member.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class JsonVisitorSignUpRequest {

  @NotNull
  @JsonProperty
  private String uuid;

  @NotEmpty
  @JsonProperty
  private boolean isPC;
}
