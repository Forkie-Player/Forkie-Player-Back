package toolc.yourlist.member.domain.loginId;

class NonNull implements LoginIdPolicy {

  @Override
  public boolean matches(String rawId) {
    return rawId != null;
  }
}
