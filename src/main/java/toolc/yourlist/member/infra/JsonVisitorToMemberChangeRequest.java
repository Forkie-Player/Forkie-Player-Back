package toolc.yourlist.member.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class JsonVisitorToMemberChangeRequest {

  @NotBlank
  @JsonProperty
  private String uuid;

  @NotBlank
  @JsonProperty
  private String loginId;

  @NotBlank
  @JsonProperty
  private String password;

  @NotBlank
  @JsonProperty
  Boolean isPC;
}