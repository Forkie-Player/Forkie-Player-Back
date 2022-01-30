package toolc.yourlist.playlist.domain;

public class NotOwnerException extends RuntimeException {
  private static final String MESSAGE = "요청 대상(Member)과 Target의 소유자(Member)가 다릅니다.";

  public NotOwnerException() {
    super(MESSAGE);
  }
}
