package toolc.yourlist.auth.domain.request;

import java.util.Arrays;

class AllowOnlyAlphabetOrNumberOrSpecialCharacter implements PasswordPolicy {

  String regex = "[A-Za-z0-9~!@#$%^&*()+|=]";

  @Override
  public boolean matches(String rawPassword) {
    return Arrays.stream(rawPassword.split(""))
      .allMatch(a -> a.matches(regex));
  }
}
