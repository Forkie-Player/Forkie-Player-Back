package toolc.yourlist.playlist.infra;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
class AllPlaylists {
  private final List<PlaylistEntity> entities;

  AllPlaylists(List<PlaylistEntity> entities) {
    final int size = entities.stream()
      .map(PlaylistEntity::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new IllegalArgumentException("같은 멤버의 영상목록이 아닙니다.");
    }

    this.entities = entities;
  }
}
