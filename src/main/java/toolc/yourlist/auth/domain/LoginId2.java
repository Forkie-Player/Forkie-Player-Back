package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EqualsAndHashCode
public final class LoginId2 {
  String raw;

  public LoginId2(String raw) {
    if (raw == null || raw.equals("")) {
      throw new IllegalArgumentException();
    }
    this.raw = raw;
  }

  private void validateId(String id) {
    Matcher matcher;
    final int min = 6;
    final int max = 20;

    final String regex =
      "^[a-z]+[a-z0-9]{" + Integer.toString(min - 1) + "," + Integer.toString(max - 1) + "}$";

    matcher = Pattern.compile(regex).matcher(id);
    if (!matcher.find()) {
      throw new IllegalArgumentException("잘못된 LoginId 입니다.");
    }
  }
}
