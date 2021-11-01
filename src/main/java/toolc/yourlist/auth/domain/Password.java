package toolc.yourlist.auth.domain;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Password {
  @Getter
  private final String password;

  Password(String password) {
    validatePassword(password);
    this.password = password;
  }

  private void validatePassword(String password) {
    Matcher matcher;

    final int min = 8;
    final int max = 20;

    final String regex =
      "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{" + min + "," + max + "})$";

    matcher = Pattern.compile(regex).matcher(password);
    if (!matcher.find()) {
      throw new NotValidatedLoginRequestException("잘못된 Password 입니다.");
    }
  }


}
