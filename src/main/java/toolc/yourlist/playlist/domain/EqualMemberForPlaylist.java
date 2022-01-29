package toolc.yourlist.playlist.domain;

public record EqualMemberForPlaylist(Member member, Playlist playlist) {
  private final static EqualMemberCondition condition = new EqualMemberCondition();

  public EqualMemberForPlaylist {
    condition.check(member, playlist);
  }
}
