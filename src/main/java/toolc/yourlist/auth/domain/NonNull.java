package toolc.yourlist.auth.domain;

class NonNull implements LoginIdPolicy {

  @Override
  public boolean matches(String rawId) {
    return rawId != null;
  }
}
