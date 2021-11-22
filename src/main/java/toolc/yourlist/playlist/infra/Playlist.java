package toolc.yourlist.playlist.infra;

import lombok.Getter;

import java.util.Optional;

@Getter
class Playlist {
  private final PlaylistEntity entity;

  Playlist(Optional<PlaylistEntity> optionalEntity) {
    if (optionalEntity.isEmpty()) {
      throw new IllegalArgumentException("존재하지 않는 영상 목록입니다.");
    }

    this.entity = optionalEntity.get();
  }
}
