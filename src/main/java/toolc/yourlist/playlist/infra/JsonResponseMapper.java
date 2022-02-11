package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Playlists;
import toolc.yourlist.playlist.domain.Plays;

import java.util.List;
import java.util.stream.Collectors;

public class JsonResponseMapper {
  List<PlaylistJson> toPlaylistJsonList(Playlists playlists) {
    return playlists.map(PlaylistJson::new).collect(Collectors.toList());
  }

  List<PlayJson> toPlayJsonList(Plays plays) {
    return plays.map(PlayJson::new).collect(Collectors.toList());
  }
}