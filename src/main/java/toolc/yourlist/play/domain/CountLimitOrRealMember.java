package toolc.yourlist.play.domain;

public class CountLimitOrRealMember implements SaveRequestPolicy {
  SaveRequestPolicy realMember = new RealMember();
  SaveRequestPolicy countLimit = new CountLimit();

  @Override
  public boolean matches(PlaylistSaveRequest request) {
    return realMember.matches(request) ||
      countLimit.matches(request);
  }
}
