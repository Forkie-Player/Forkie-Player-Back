package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.PlaylistJson;
import toolc.yourlist.playlist.domain.PlaylistWithThumbnail;

import java.util.List;
import java.util.stream.Collectors;

class PlaylistWithThumbnailMapper {
  List<PlaylistJson> toPlaylistJson(List<PlaylistWithThumbnail> playlists) {
    return playlists.stream()
      .map(PlaylistJson::new)
      .collect(Collectors.toList());
  }
}
