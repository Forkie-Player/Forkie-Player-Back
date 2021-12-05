package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.ListOfPlaylists;

import java.util.List;
import java.util.stream.Collectors;

public final class ListOfPlaylistsMapper {
  List<PlaylistJson> toPlaylistJsonList(ListOfPlaylists listOfPlaylists) {
    return listOfPlaylists.entities()
      .stream()
      .map(PlaylistJson::new)
      .collect(Collectors.toList());
  }
}
