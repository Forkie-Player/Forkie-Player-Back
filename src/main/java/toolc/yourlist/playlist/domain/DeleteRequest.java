package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import toolc.yourlist.member.domain.Member;

@Getter
@EqualsAndHashCode
public class DeleteRequest {
  private final Member member;
  private final Playlist playlist;

  public DeleteRequest(Member member, Playlist playlist) {
    this.member = member;
    this.playlist = playlist;
  }
}
