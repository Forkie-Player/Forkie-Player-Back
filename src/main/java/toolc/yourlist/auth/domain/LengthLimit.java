package toolc.yourlist.auth.domain;

class LengthLimit implements LoginIdPolicy {

  @Override
  public boolean matches(String rawId) {
    return rawId.length() >= 6 && rawId.length() <= 20;
  }
}
