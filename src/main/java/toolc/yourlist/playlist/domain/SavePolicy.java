package toolc.yourlist.playlist.domain;

final class SavePolicy {
  private final PlaylistCountCondition countCondition = new PlaylistCountCondition();
  private final RealMemberCondition realMemberCondition = new RealMemberCondition();

  boolean match(User user, Long count) {
    return countCondition.check(count) ||
      realMemberCondition.check(user);
  }
}
