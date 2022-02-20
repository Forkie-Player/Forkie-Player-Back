package toolc.yourlist.member.domain.password;

import java.util.Arrays;

class AllowAlphabetOrNumberOrSpecialCharacter implements PasswordPolicy {

  String regex = "[A-Za-z0-9~!@#$%^&*()+|=]";

  @Override
  public boolean matches(String rawPassword) {
    return Arrays.stream(rawPassword.split(""))
      .allMatch(a -> a.matches(regex));
  }
}
