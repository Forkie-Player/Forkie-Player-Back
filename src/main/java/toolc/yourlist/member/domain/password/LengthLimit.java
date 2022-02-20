package toolc.yourlist.member.domain.password;

class LengthLimit implements PasswordPolicy {

  @Override
  public boolean matches(String rawPassword) {
    return rawPassword.length() >= 8 && rawPassword.length() <= 20;
  }

}
