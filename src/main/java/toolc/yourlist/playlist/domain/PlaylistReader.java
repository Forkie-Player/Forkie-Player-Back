package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistReader {
  private final AllPlaylists allPlaylists;

  public ListOfPlaylists belongsTo(ReadRequest request) {
    return allPlaylists.readAllBelongsTo(request.member().id());
  }
}
