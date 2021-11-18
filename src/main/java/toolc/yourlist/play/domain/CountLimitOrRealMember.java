package toolc.yourlist.play.domain;

public class CountLimitOrRealMember implements SavePolicy {
  SavePolicy realMember = new RealMember();
  SavePolicy countLimit = new CountLimit();

  @Override
  public boolean matches(SaveRequest request) {
    return realMember.matches(request) ||
      countLimit.matches(request);
  }
}
