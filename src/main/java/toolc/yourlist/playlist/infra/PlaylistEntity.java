package toolc.yourlist.playlist.infra;

import lombok.*;
import toolc.yourlist.common.domain.BaseEntity;
import toolc.yourlist.playlist.domain.Playlist;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "playlist")
public class PlaylistEntity extends BaseEntity {
  private Long memberId;
  @Setter
  private String title;

  public PlaylistEntity(Long memberId, String title) {
    this.memberId = memberId;
    this.title = title;
  }

  Playlist toPlaylist() {
    return new Playlist(memberId, title);
  }
}

