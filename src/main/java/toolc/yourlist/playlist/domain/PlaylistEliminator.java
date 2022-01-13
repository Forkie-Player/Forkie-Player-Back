package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistEliminator {
  private final AllPlaylists allPlaylists;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  public void delete(DeleteRequest request) {
    equalCondition.check(request.member(), request.playlist());

    allPlaylists.delete(request.playlist());
  }
}
