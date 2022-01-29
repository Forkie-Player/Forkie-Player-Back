package toolc.yourlist.playlist.domain;

public record EqualOwnerForPlay(
  Member member,
  Play play
) {
  private final static EqualOwnerCondition condition = new EqualOwnerCondition();

  public EqualOwnerForPlay(Member member, Playlist playlist, Play play) {
    this(member, play);
    condition.check(member, playlist);
  }
}
