package toolc.yourlist.common.domain;

public class ContractViolationException extends RuntimeException {
  public ContractViolationException(String message) {
    super(message);
  }
}
