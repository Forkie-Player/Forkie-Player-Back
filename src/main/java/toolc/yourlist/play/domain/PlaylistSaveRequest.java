package toolc.yourlist.play.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
class PlaylistSaveRequest {
  private final Long memberId;
  private final String title;
  private final boolean isMember;
  private final int playlistCount;

  @Builder
  public PlaylistSaveRequest(Long memberId, String title, boolean isMember, int playlistCount) {
    this.memberId = memberId;
    this.title = title;
    this.isMember = isMember;
    this.playlistCount = playlistCount;
  }
}
