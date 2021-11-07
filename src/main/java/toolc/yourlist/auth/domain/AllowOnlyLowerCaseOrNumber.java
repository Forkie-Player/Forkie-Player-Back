package toolc.yourlist.auth.domain;

class AllowOnlyLowerCaseOrNumber implements LoginIdPolicy {

  @Override
  public boolean matches(String rawId) {
    return rawId.chars()
      .allMatch(a -> ('a' <= a && a <= 'z') || ('0' <= a && a <= '9'));
  }
}
