package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EqualsAndHashCode
public final class LoginId2 {
  String raw;

  public LoginId2(String raw) {
    validateId(raw);
    this.raw = raw;
  }

  private void validateId(String raw) {
    if (raw == null) {
      throw new IllegalArgumentException();
    }

    Matcher matcher;
    final int min = 6;
    final int max = 20;

    final String regex =
      "^[a-z]+[a-z0-9]{" + Integer.toString(min - 1) + "," + Integer.toString(max - 1) + "}$";

    matcher = Pattern.compile(regex).matcher(raw);
    if (!matcher.find()) {
      throw new IllegalArgumentException("잘못된 LoginId 입니다.");
    }
  }
}
