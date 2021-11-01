package toolc.yourlist.auth.domain;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LoginId {
  @Getter
  private final String id;

  LoginId(String id) {
    validateId(id);
    this.id = id;
  }

  private void validateId(String id) {
    Matcher matcher;
    final int min = 6;
    final int max = 20;

    final String regex =
      "^[a-z]+[a-z0-9]{" + Integer.toString(min - 1) + "," + Integer.toString(max - 1) + "}$";

    matcher = Pattern.compile(regex).matcher(id);
    if (!matcher.find()) {
      throw new NotValidatedLoginRequestException("잘못된 LoginId 입니다.");
    }
  }


}
