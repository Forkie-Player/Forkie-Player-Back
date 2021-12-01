package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.AllPlaylists;

import java.util.List;
import java.util.stream.Collectors;

public class AllPlaylistsMapper {
  List<PlaylistJson> toPlaylistJsonList(AllPlaylists allPlaylists) {
    return allPlaylists.entities()
      .stream()
      .map(PlaylistJson::new)
      .collect(Collectors.toList());
  }
}
