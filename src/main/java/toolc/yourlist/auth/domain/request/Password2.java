package toolc.yourlist.auth.domain.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
final class Password2 {

  private String raw;

  public Password2(String raw) {
    this.raw = raw;
  }
}
