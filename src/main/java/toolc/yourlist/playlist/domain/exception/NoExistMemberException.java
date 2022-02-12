package toolc.yourlist.playlist.domain.exception;

public class NoExistMemberException extends RuntimeException {
  private static final String MESSAGE = "존재하지 않는 회원";

  public NoExistMemberException() {
    super(MESSAGE);
  }
}
