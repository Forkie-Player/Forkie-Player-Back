package toolc.yourlist.auth.domain.request;

import java.util.Arrays;

class PasswordHaveSpecialCharacter implements PasswordPolicy {

  String regex = "[~!@#$%^&*()+|=]";

  @Override
  public boolean matches(String rawPassword) {
    return Arrays.stream(rawPassword.split(""))
      .anyMatch(a -> a.matches(regex));
  }
}
