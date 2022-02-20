package toolc.yourlist.member.domain.loginId;


class AllowLowerCaseOrNumber implements LoginIdPolicy {

  @Override
  public boolean matches(String rawId) {
    return rawId.chars()
      .allMatch(a -> ('a' <= a && a <= 'z') || ('0' <= a && a <= '9'));
  }
}
