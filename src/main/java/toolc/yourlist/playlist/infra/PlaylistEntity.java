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
  private Long memberId;
  @Setter
  private String title;
  private String thumbnail;

  public PlaylistEntity(Long memberId, String title, String thumbnail) {
    this.memberId = memberId;
    this.title = title;
    this.thumbnail = thumbnail;
  }

  public PlaylistEntity(Playlist playlist) {
    this.memberId = playlist.memberId();
    this.title = playlist.title();
    this.thumbnail = playlist.thumbnail();
  }
}

