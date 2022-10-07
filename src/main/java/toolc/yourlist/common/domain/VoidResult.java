package toolc.yourlist.common.domain;

import java.util.Objects;

public class VoidResult {
  private String errorMessage;

  private VoidResult() {
  }

  private VoidResult(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public static VoidResult ofWithError(String errorMessage) {
    return new VoidResult(Objects.requireNonNull(errorMessage));
  }

  public static VoidResult of() {
    return new VoidResult();
  }

  public boolean hasError() {
    return errorMessage != null;
  }

  public String message() {
    return Objects.requireNonNull(errorMessage);
  }
}
