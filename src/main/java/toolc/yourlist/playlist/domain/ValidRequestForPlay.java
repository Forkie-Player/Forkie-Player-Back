package toolc.yourlist.playlist.domain;

public record ValidRequestForPlay(
  Play play
) {
  private final static EqualCondition condition = new EqualCondition();

  public ValidRequestForPlay(Member member, Playlist playlist, Play play) {
    this(play);
    condition.checkMember(member, playlist);
    condition.checkPlaylist(playlist, play);
  }
}
