package toolc.yourlist.auth.domain.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EqualsAndHashCode
final class LoginId2 {
  @Getter
  private String raw;

  LoginId2(String raw) {
    this.raw = raw;
  }
}