package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistUpdater {
  private final AllPlaylists allPlaylists;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  public void updateTitle(UpdateRequest request) {
    equalCondition.check(request.member(), request.playlist());

    allPlaylists.updateTitleBelongsTo(request.playlist().id(), request.title());
  }
}
