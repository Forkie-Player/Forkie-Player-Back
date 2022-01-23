package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistEliminator {
  private final AllPlaylists allPlaylists;

  public void delete(DeleteRequest request) {
    allPlaylists.delete(request.equalOwner().playlist());
  }
}
