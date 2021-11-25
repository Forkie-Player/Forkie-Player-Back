package toolc.yourlist.playlist.infra;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Optional;

@Getter
@EqualsAndHashCode
class Playlist {
  @EqualsAndHashCode.Exclude
  private final PlaylistEntity entity;

  private final Long memberId;
  private final String title;

  Playlist(Optional<PlaylistEntity> optionalEntity) {
    this.entity = optionalEntity.orElseThrow(
      () -> new IllegalArgumentException("존재하지 않는 영상 목록입니다.")
    );

    this.memberId = entity.memberId();
    this.title = entity.title();
  }
}
