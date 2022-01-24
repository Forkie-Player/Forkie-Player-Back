package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.ListOfPlaylists;

import java.util.List;
import java.util.stream.Collectors;

class ListOfPlaylistsMapper {
  List<PlaylistJson> toPlaylistJsonList(ListOfPlaylists listOfPlaylists) {
    return listOfPlaylists.list()
      .stream()
      .map(PlaylistJson::new)
      .collect(Collectors.toList());
  }
}
