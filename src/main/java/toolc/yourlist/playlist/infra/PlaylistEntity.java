package toolc.yourlist.playlist.infra;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toolc.yourlist.common.domain.BaseEntity;
import toolc.yourlist.playlist.domain.Playlist;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "playlist")
public class PlaylistEntity extends BaseEntity {
  private Long memberId;
  @Setter
  private String title;
  private String thumbnail;

  public PlaylistEntity(Long memberId, String title) {
    this.memberId = memberId;
    this.title = title;
  }

  Playlist toPlaylist() {
    return new Playlist(this.id(), memberId, title, thumbnail);
  }
}

