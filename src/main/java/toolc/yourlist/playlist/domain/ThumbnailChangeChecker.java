package toolc.yourlist.playlist.domain;

public class ThumbnailChangeChecker {
  public boolean checkSizeOne(Long playlistSize) {
    return playlistSize == 1;
  }

  public boolean checkSizeZero(Long playlistSize) {
    return playlistSize == 0;
  }

  public boolean check(Long originSequence, Long changeToSequence) {
    return !originSequence.equals(changeToSequence) && changeToSequence == 0L;
  }
}
