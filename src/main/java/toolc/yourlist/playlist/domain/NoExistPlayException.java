package toolc.yourlist.playlist.domain;

public class NoExistPlayException extends RuntimeException {
  private static final String MESSAGE = "존재하지 않는 영상";

  public NoExistPlayException() {
    super(MESSAGE);
  }
}
