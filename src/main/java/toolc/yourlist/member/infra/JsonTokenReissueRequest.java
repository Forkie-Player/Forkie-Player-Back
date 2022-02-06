package toolc.yourlist.member.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class JsonTokenReissueRequest {

  @NotBlank
  @JsonProperty
  private String accessToken;

  @NotBlank
  @JsonProperty
  private String refreshToken;

  @NotBlank
  @JsonProperty
  Boolean isPC;
}
