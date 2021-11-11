package toolc.yourlist.auth.domain.request;

class PasswordNonNull implements PasswordPolicy {

  @Override
  public boolean matches(String rawPassword) {
    return rawPassword != null;
  }
}
