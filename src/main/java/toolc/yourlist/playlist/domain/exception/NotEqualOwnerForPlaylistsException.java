package toolc.yourlist.playlist.domain.exception;

public class NotEqualOwnerForPlaylistsException extends RuntimeException {
  private static final String MESSAGE = "같은 멤버의 영상목록들이 아닙니다.";

  public NotEqualOwnerForPlaylistsException() {
    super(MESSAGE);
  }
}
