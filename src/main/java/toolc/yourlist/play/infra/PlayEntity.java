package toolc.yourlist.play.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "play")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PlayEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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
