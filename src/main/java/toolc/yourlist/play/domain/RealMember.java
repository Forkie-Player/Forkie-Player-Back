package toolc.yourlist.play.domain;

class RealMember implements SavePolicy {
  @Override
  public boolean matches(PlaylistSaveRequest request) {
    return request.isMember();
  }
}
