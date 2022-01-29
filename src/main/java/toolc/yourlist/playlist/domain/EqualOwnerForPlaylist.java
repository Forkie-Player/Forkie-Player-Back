package toolc.yourlist.playlist.domain;

public record EqualOwnerForPlaylist(Member member, Playlist playlist) {
  private final static EqualOwnerCondition condition = new EqualOwnerCondition();

  public EqualOwnerForPlaylist {
    condition.check(member, playlist);
  }
}
