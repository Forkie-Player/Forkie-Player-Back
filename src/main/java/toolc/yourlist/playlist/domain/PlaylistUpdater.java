package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistUpdater {
  private final AllPlaylists allPlaylists;

  public void updateTitle(UpdateRequest request) {
    allPlaylists.updateTitleBelongsTo(request.equalOwnerForPlaylist().playlist().id(), request.title());
  }
}
