package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.ThumbnailChangeChecker;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.PlaylistThumbnail;

@RequiredArgsConstructor
class ThumbnailChanger implements PlaylistThumbnail {
  private final AllPlaylists allPlaylists;
  private final ThumbnailChangeChecker changeChecker = new ThumbnailChangeChecker();

  @Override
  public void change(Long playlistId, String thumbnail, Long playlistSize) {
    if (changeChecker.check(playlistSize)) {
      allPlaylists.updateThumbnail(playlistId, thumbnail);
    }
  }
}
