package toolc.yourlist.auth.domain.request;

class PasswordLengthLimit implements PasswordPolicy {

  @Override
  public boolean matches(String rawPassword) {
    return rawPassword.length() >= 8 && rawPassword.length() <= 20;
  }

}
