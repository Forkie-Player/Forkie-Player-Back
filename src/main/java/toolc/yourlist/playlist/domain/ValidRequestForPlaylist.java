package toolc.yourlist.playlist.domain;

public record ValidRequestForPlaylist(Playlist playlist) {
  private final static EqualCondition condition = new EqualCondition();

  public ValidRequestForPlaylist(Member member, Playlist playlist) {
    this(playlist);
    condition.checkMember(member, playlist);
  }
}
