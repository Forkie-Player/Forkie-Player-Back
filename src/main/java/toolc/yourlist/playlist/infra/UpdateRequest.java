package toolc.yourlist.playlist.infra;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import toolc.yourlist.member.domain.Member;

@Getter
@EqualsAndHashCode
public class UpdateRequest {
  private final Member member;
  private final Long playlistId;
  private final String title;

  @Builder
  public UpdateRequest(Member member, Long playlistId, String title) {
    this.member = member;
    this.playlistId = playlistId;
    this.title = title;
  }
}
