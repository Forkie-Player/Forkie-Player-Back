package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class DeleteRequest {
  private final Member member;
  private final Playlist playlist;

  DeleteRequest(Member member, Playlist playlist) {
    this.member = member;
    this.playlist = playlist;
  }
}
