package toolc.yourlist.member.domain;

public class NotExistMemberException extends RuntimeException {
  private static final String MESSAGE = "존재하지 않는 사용자입니다.";

  public NotExistMemberException() {
    super(MESSAGE);
  }
}