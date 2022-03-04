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
class PlaylistEntity extends BaseEntity {
  private String userCode;
  @Setter
  private String title;
  @Setter
  private String thumbnail;

  public PlaylistEntity(String userCode, String title, String thumbnail) {
    this.userCode = userCode;
    this.title = title;
    this.thumbnail = thumbnail;
  }

  public PlaylistEntity(Playlist playlist) {
    this.userCode = playlist.userCode();
    this.title = playlist.title();
    this.thumbnail = playlist.thumbnail();
  }
}

