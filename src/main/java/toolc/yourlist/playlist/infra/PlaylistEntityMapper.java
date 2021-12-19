package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class PlaylistEntityMapper {
  Optional<Playlist> toPlaylist(Optional<PlaylistEntity> entity) {
    if (entity.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(Playlist.builder()
      .id(entity.get().id())
      .memberId(entity.get().memberId())
      .title(entity.get().title())
      .thumbnail(entity.get().thumbnail())
      .build());
  }

  ListOfPlaylists toListOfPlaylists(List<PlaylistEntity> entityList) {
    return new ListOfPlaylists(entityList.stream()
      .map(entity -> Playlist.builder()
        .id(entity.id())
        .memberId(entity.memberId())
        .title(entity.title())
        .thumbnail(entity.thumbnail())
        .build())
      .collect(Collectors.toList()));
  }
}