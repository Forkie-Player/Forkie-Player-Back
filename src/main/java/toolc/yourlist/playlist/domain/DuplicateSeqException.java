package toolc.yourlist.playlist.domain;

public class DuplicateSeqException extends RuntimeException {
  private static final String MESSAGE = "영상의 순서가 중복되었습니다.";

  public DuplicateSeqException() {
    super(MESSAGE);
  }
}
