package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Playlists;
import toolc.yourlist.playlist.domain.exception.NoExistPlaylistException;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class PlaylistEntityMapper {
  Playlist toPlaylist(PlaylistEntity entity) {
    return Playlist.builder()
      .id(entity.id())
      .memberId(entity.memberId())
      .title(entity.title())
      .thumbnail(entity.thumbnail())
      .build();
  }

  Playlists toPlaylists(List<PlaylistEntity> entityList) {
    final var list = entityList.stream()
      .map(this::toPlaylist)
      .collect(Collectors.toList());

    return new Playlists(list);
  }
}
