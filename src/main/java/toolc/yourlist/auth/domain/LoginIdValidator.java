package toolc.yourlist.auth.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginIdValidator {
  public static void validateId(String loginId) {
    final int min = 6;
    final int max = 20;

    final String regex =
      "^[a-z]+[a-z0-9]{" + Integer.toString(min - 1) + "," + Integer.toString(max - 1) + "}$";

    Matcher matcher;
    matcher = Pattern.compile(regex).matcher(loginId);
    if (!matcher.find()) {
      throw new NotValidatedLoginRequestException("잘못된 LoginId 입니다.");
    }

  }
}
