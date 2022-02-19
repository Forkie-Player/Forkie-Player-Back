package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class ValidRequestForPlay {
  private final Play play;
  private final static EqualCondition condition = new EqualCondition();

  private ValidRequestForPlay(Play play) {
    this.play = play;
  }

  public ValidRequestForPlay(Member member, Playlist playlist, Play play) {
    this(play);
    condition.checkMember(member, playlist);
    condition.checkPlaylist(playlist, play);
  }

  public Play get() {
    return play;
  }
}
