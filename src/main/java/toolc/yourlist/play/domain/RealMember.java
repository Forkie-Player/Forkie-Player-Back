package toolc.yourlist.play.domain;

class RealMember implements SaveRequestPolicy {
  @Override
  public boolean matches(PlaylistSaveRequest request) {
    return request.isMember();
  }
}
