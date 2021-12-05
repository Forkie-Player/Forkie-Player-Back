package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public interface PlaylistCountCondition {
  boolean check(long havingCount);
}
