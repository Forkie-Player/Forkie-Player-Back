package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayReader {
  private final AllPlay allPlay;

  public Plays readAllPlays(ReadAllPlaysRequest request) {
    return allPlay.readAllBelongsTo(request.validRequestForPlaylist().get().id());
  }
}
