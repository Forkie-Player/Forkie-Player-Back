package toolc.yourlist.playlist.domain;

import lombok.Getter;

@Getter
public class ReadRequest {
  private final String loginId;

  public ReadRequest(String loginId) {
    this.loginId = loginId;
  }
}
