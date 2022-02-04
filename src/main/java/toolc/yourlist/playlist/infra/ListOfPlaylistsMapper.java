package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Playlists;

import java.util.List;
import java.util.stream.Collectors;

class ListOfPlaylistsMapper {
  List<PlaylistJson> toPlaylistJsonList(Playlists playlists) {
    return playlists.list()
      .stream()
      .map(PlaylistJson::new)
      .collect(Collectors.toList());
  }
}
