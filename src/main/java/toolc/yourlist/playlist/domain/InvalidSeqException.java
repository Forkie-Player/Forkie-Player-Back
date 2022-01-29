package toolc.yourlist.playlist.domain;

public class InvalidSeqException extends RuntimeException {
  private static final String MESSAGE = "영상의 순서에 오류가 있습니다.";

  public InvalidSeqException() {
    super(MESSAGE);
  }
}
