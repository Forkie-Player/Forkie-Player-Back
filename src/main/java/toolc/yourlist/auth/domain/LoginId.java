package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EqualsAndHashCode
public final class LoginId {
  @Getter
  private String raw;

  LoginId(String raw) {
    this.raw = raw;
  }
}