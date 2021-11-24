package toolc.yourlist.playlist.infra;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@EqualsAndHashCode
class Playlist {
  @EqualsAndHashCode.Exclude
  private final PlaylistEntity entity;

  private final Long memberId;
  private final String title;

  Playlist(Optional<PlaylistEntity> optionalEntity) {
    if (optionalEntity.isEmpty()) {
      throw new IllegalArgumentException("존재하지 않는 영상 목록입니다.");
    }

    this.entity = optionalEntity.get();
    this.memberId = entity().memberId();
    this.title = entity().title();
  }
}
