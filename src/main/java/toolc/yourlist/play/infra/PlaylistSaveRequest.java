package toolc.yourlist.play.infra;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public final class PlaylistSaveRequest {
  @NotNull
  private final Long memberId;
  @NotEmpty
  private final String title;
  @NotNull
  private final boolean isMember;

  private final int playlistCount;

  @Builder
  PlaylistSaveRequest(Long memberId, String title, boolean isMember, int playlistCount) {
    this.memberId = memberId;
    this.title = title;
    this.isMember = isMember;
    this.playlistCount = playlistCount;
  }
}
