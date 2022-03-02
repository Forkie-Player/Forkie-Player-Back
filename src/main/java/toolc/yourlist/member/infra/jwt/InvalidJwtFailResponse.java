package toolc.yourlist.member.infra.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = false)
public class InvalidJwtFailResponse{
  private final int status;
  private final String message;

  @Builder
  public InvalidJwtFailResponse(int status, String message) {
    this.status = status;
    this.message = message;
  }
}
