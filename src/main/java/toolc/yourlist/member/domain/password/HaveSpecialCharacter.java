package toolc.yourlist.member.domain.password;

import java.util.Arrays;

class HaveSpecialCharacter implements PasswordPolicy {

  String allowSpecialCharacter = "[~!@#$%^&*()+|=]";

  @Override
  public boolean matches(String rawPassword) {
    return Arrays.stream(rawPassword.split(""))
      .anyMatch(a -> a.matches(allowSpecialCharacter));
  }
}
