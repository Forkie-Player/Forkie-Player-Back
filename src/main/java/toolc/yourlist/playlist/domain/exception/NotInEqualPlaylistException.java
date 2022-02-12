package toolc.yourlist.playlist.domain.exception;

public class NotInEqualPlaylistException extends RuntimeException {
  private static final String MESSAGE = "같은 영상 목록 내 영상들이 아닙니다.";

  public NotInEqualPlaylistException() {
    super(MESSAGE);
  }
}
