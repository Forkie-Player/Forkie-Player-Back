package toolc.yourlist.auth.domain;

class NotValidatedLoginRequestException extends RuntimeException {

  public NotValidatedLoginRequestException(String message) {
    super(message);
  }

}
