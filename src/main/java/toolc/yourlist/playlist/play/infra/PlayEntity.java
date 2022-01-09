package toolc.yourlist.playlist.play.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "play")
public class PlayEntity extends BaseEntity {
  private int sequence;

  private String thumbnail;

  private Long playlistId;

  @Builder
  public PlayEntity(int sequence, String thumbnail, Long playlistId) {
    this.sequence = sequence;
    this.thumbnail = thumbnail;
    this.playlistId = playlistId;
  }
}