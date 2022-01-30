package toolc.yourlist.playlist.domain;

public record EqualMemberForPlay(
  Member member,
  Play play
) {
  private final static EqualMemberCondition condition = new EqualMemberCondition();

  public EqualMemberForPlay(Member member, Playlist playlist, Play play) {
    this(member, play);
    condition.check(member, playlist);
  }
}
