package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class PlaylistCountCondition {
  public boolean check(long havingCount) {
    return havingCount < 5;
  }
}
