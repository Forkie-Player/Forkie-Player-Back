package toolc.yourlist.playlist.infra;

import lombok.Getter;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
class AllPlaylists {
  private final List<Playlist> entities;

  AllPlaylists(List<PlaylistEntity> playlistEntities) {
    final int size = playlistEntities.stream()
      .map(PlaylistEntity::memberId)
      .collect(Collectors.toUnmodifiableSet())
      .size();

    if (size != 1) {
      throw new IllegalArgumentException("같은 멤버의 영상목록이 아닙니다.");
    }

    this.entities = playlistEntities.stream()
      .map(PlaylistEntity::toPlaylist)
      .collect(Collectors.toList());
  }
}
