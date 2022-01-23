package toolc.yourlist.playlist.domain;

public record EqualOwner(Member member, Playlist playlist) {
  private final static EqualOwnerCondition condition = new EqualOwnerCondition();

  public EqualOwner {
    condition.check(member, playlist);
  }
}
