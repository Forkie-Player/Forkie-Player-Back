package toolc.yourlist.member.domain.loginId;

class IncludeSingleAtSign implements LoginIdPolicy {

  @Override
  public boolean matches(String rawId) {
    long atSignCount = rawId.chars()
      .filter(c -> c == '@')
      .count();

    return atSignCount == 1L;
  }
}
