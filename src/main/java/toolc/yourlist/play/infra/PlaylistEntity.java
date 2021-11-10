package toolc.yourlist.play.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name = "playlist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PlaylistEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long memberId;

  @Builder
  public PlaylistEntity(Long memberId) {
    this.memberId = memberId;
  }
}

