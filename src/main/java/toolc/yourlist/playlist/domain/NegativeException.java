package toolc.yourlist.playlist.domain;

public class NegativeException extends RuntimeException{
  private static final String MESSAGE = "음수일 수 없는 값입니다.";

  public NegativeException() {
    super(MESSAGE);
  }
}
