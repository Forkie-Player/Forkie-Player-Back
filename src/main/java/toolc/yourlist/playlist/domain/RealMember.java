package toolc.yourlist.playlist.domain;

class RealMember implements SavePolicy {
  @Override
  public boolean matches(SaveRequest request) {
    return request.isMember();
  }
}
