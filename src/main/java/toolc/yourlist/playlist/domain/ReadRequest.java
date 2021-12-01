package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ReadRequest {
  private final String loginId;

  public ReadRequest(String loginId) {
    this.loginId = loginId;
  }
}
