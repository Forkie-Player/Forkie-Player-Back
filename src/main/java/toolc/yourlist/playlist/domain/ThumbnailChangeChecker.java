package toolc.yourlist.playlist.domain;

public class ThumbnailChangeChecker {
  public boolean checkSize(Long playlistSize) {
    return playlistSize == 0;
  }

  public boolean check(Long originSequence, Long changeToSequence) {
    return !originSequence.equals(changeToSequence) && changeToSequence == 1L;
  }
}
