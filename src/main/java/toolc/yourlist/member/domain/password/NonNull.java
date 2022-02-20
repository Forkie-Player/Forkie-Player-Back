package toolc.yourlist.member.domain.password;

class NonNull implements PasswordPolicy {

  @Override
  public boolean matches(String rawPassword) {
    return rawPassword != null;
  }
}
