package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.*;

@RequiredArgsConstructor
class PlaylistThumbnail implements ChangeThumbnail {
  private final AllPlaylists allPlaylists;
  private final ThumbnailChangeChecker changeChecker = new ThumbnailChangeChecker();

  @Override
  public void changeForMakingFirstPlay(Long playlistId, String thumbnail, Long playlistSize) {
    if (changeChecker.checkSize(playlistSize)) {
      allPlaylists.updateThumbnail(playlistId, thumbnail);
    }
  }

  @Override
  public void changeForUpdateSequence(Play play, Long sequenceToChange) {
    if (changeChecker.check(play.sequence(), sequenceToChange)) {
      allPlaylists.updateThumbnail(play.playlistId(), play.info().thumbnail());
    }
  }
}
