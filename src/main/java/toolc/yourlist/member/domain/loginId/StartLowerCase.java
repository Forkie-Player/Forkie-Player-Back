package toolc.yourlist.member.domain.loginId;

class StartLowerCase implements LoginIdPolicy {

  @Override
  public boolean matches(String rawId) {
    return 'a' <= rawId.charAt(0) && rawId.charAt(0) <= 'z';
  }
}
