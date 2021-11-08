package toolc.yourlist.auth.domain.request;

class NotValidatedLoginRequestException extends RuntimeException {

  public NotValidatedLoginRequestException(String message) {
    super(message);
  }

}
