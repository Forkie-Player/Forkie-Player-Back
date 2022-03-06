package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistReader {
  private final AllPlaylists allPlaylists;

  public Playlists belongsTo(User user) {
    return allPlaylists.readAllBelongsTo(user);
  }
}
