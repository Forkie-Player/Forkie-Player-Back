package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import toolc.yourlist.member.domain.Member;

@Getter
@EqualsAndHashCode
public final class UpdateRequest {
  private final Member member;
  private final Playlist playlist;
  private final String title;

  public UpdateRequest(Member member, Playlist playlist, String title) {
    this.playlist = playlist;
    this.title = title;
    this.member = member;
  }
}
