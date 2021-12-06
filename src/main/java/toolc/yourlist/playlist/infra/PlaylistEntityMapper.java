package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
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

  ListOfPlaylists toListOfPlaylists(List<PlaylistEntity> entityList) {
    return new ListOfPlaylists(entityList
      .stream()
      .map(this::toPlaylist)
      .collect(Collectors.toList()));
  }
}
