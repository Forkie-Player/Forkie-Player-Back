package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.PlaylistWithThumbnail;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class PlaylistReader {
  private final ReadPersisting readPersisting;
  private final ReadThumbnail thumbnailOfPlaylist;

  List<PlaylistWithThumbnail> readAllPlaylists(String loginId) {
    var playlists = readPersisting.readAllBelongsTo(loginId);
    return playlists.entities()
      .stream()
      .map(playlist ->
        new PlaylistWithThumbnail(
          playlist.id(),
          playlist.title(),
          thumbnailOfPlaylist.find(playlist.id())))
      .collect(Collectors.toList());
  }
}
