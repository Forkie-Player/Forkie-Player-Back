package toolc.yourlist.playlist.domain.exception;

public class DuplicateIdInListException extends RuntimeException {
  private static final String MESSAGE = "리스트 내 중복된 Id가 존재합니다.";

  public DuplicateIdInListException() {
    super(MESSAGE);
  }
}
