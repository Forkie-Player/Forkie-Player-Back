package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllPlaylists;

@RequiredArgsConstructor
class PlaylistReader {
  private final ReadPersisting readPersisting;

  AllPlaylists readAllPlaylists(String loginId) {
    return readPersisting.readAllBelongsTo(loginId);
  }
}
