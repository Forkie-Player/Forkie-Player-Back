package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.List;
import java.util.stream.Collectors;

class PlaylistEntityMapper { // TODO: Test 필요!
  Playlist toPlaylist(PlaylistEntity entity) {
    return new Playlist(entity.memberId(), entity.title(), entity.thumbnail());
  }

  ListOfPlaylists toListOfPlaylists(List<PlaylistEntity> entityList) {
    return new ListOfPlaylists(entityList
      .stream()
      .map(this::toPlaylist)
      .collect(Collectors.toList()));
  }
}
