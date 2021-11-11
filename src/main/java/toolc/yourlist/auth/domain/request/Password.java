package toolc.yourlist.auth.domain.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
final class Password {

  @Getter
  private String raw;

  public Password(String raw) {
    this.raw = raw;
  }
}
