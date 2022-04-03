package toolc.yourlist.playlist.domain;

final class PlaylistCountCondition {
  boolean check(long havingCount) {
    return havingCount < 3;
  }
}
