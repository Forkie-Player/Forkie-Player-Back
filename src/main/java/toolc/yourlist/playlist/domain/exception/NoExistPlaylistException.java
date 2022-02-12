package toolc.yourlist.playlist.domain.exception;

public class NoExistPlaylistException extends RuntimeException {
  private static final String MESSAGE = "존재하지 않는 영상 목록";

  public NoExistPlaylistException() {
    super(MESSAGE);
  }
}
