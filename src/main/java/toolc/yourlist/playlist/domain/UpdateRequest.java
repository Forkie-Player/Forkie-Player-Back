package toolc.yourlist.playlist.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateRequest {
  private final Long memberId;
  private final Long playlistId;
  private final String title;

  @Builder
  public UpdateRequest(Long memberId, Long playlistId, String title) {
    this.memberId = memberId;
    this.playlistId = playlistId;
    this.title = title;
  }
}
