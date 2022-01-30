package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayReader {
  private final AllPlay allPlay;

  public ListOfPlays readAllPlays(ReadAllPlaysRequest request) {
    return allPlay.readAllBelongsTo(request.equalMemberForPlaylist().playlist().id());
  }
}
