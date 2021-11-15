package toolc.yourlist.auth.domain;

class PasswordNonNull implements PasswordPolicy {

  @Override
  public boolean matches(String rawPassword) {
    return rawPassword != null;
  }
}
