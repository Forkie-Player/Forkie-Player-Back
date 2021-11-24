package toolc.yourlist.playlist.infra;

import lombok.Builder;

public class UpdateRequest {
  private final String loginId;
  private final Long playlistId;
  private final String title;

  @Builder
  public UpdateRequest(String loginId, Long playlistId, String title) {
    this.loginId = loginId;
    this.playlistId = playlistId;
    this.title = title;
  }
}
