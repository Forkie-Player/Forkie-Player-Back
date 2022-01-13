package toolc.yourlist.playlist.domain;

public class NotOwnerException extends RuntimeException {
  private static final String MESSAGE = "영상 목록의 주인이 아닙니다.";

  public NotOwnerException() {
    super(MESSAGE);
  }
}
