package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
final class Password {

  @Getter
  private final String raw;

  public Password(String raw) {
    this.raw = raw;
  }
}
