package toolc.yourlist.common.domain;

public class Contracts {
  public static void requires(boolean expectedToBeTrue, String failMessage) {
    if(expectedToBeTrue) {
      return;
    }

    throw new ContractViolationException(failMessage);
  }
}
