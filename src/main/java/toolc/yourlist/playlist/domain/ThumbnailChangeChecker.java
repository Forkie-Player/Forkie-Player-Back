package toolc.yourlist.playlist.domain;

public class ThumbnailChangeChecker {
  public boolean check(long playlistSize) {
    return playlistSize == 0;
  }
}
