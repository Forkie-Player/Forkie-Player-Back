package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.ListOfPlays;

import java.util.List;
import java.util.stream.Collectors;

public class JsonResponseMapper {
  List<PlaylistJson> toPlaylistJsonList(ListOfPlaylists listOfPlaylists) {
    return listOfPlaylists.list()
      .stream()
      .map(PlaylistJson::new)
      .collect(Collectors.toList());
  }

  List<PlayJson> toPlayJsonList(ListOfPlays listOfPlays) {
    return listOfPlays.list()
      .stream()
      .map(PlayJson::new)
      .collect(Collectors.toList());
  }
}
