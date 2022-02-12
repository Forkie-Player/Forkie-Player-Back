package toolc.yourlist.playlist.domain.exception;

public class ExceedEndTimeException extends RuntimeException {
  private static final String MESSAGE = "시작시간이 종료시간보다 큽니다.";

  public ExceedEndTimeException() {
    super(MESSAGE);
  }
}
