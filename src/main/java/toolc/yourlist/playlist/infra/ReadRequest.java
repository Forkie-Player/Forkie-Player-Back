package toolc.yourlist.playlist.infra;

import lombok.Getter;

@Getter
class ReadRequest {
  private final String loginId;

  ReadRequest(String loginId) {
    this.loginId = loginId;
  }
}
