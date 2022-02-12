package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Playlists;
import toolc.yourlist.playlist.domain.exception.NoExistPlaylistException;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class PlaylistEntityMapper {
  Playlist toPlaylist(Optional<PlaylistEntity> entity) {
    if (entity.isEmpty()) {
      throw new NoExistPlaylistException();
    }

    return Playlist.builder()
      .id(entity.get().id())
      .memberId(entity.get().memberId())
      .title(entity.get().title())
      .thumbnail(entity.get().thumbnail())
      .build();
  }

  Playlists toListOfPlaylists(List<PlaylistEntity> entityList) {
    return new Playlists(entityList.stream()
      .map(entity -> Playlist.builder()
        .id(entity.id())
        .memberId(entity.memberId())
        .title(entity.title())
        .thumbnail(entity.thumbnail())
        .build())
      .collect(Collectors.toList()));
  }
}
