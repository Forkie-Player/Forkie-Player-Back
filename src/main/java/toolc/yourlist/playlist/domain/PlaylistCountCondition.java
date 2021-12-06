package toolc.yourlist.playlist.domain;

public final class PlaylistCountCondition {
  public boolean check(long havingCount) {
    return havingCount < 5;
  }
}
