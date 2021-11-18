package toolc.yourlist.playlist.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class SaveRequest {
  private final Long memberId;
  private final String title;
  private final boolean isMember;
  private final int playlistCount;

  @Builder
  public SaveRequest(Long memberId, String title, boolean isMember, int playlistCount) {
    this.memberId = memberId;
    this.title = title;
    this.isMember = isMember;
    this.playlistCount = playlistCount;
  }
}
