package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ValidRequestForPlay {
  private final Play play;
  private final static EqualCondition condition = new EqualCondition();

  private ValidRequestForPlay(Play play) {
    this.play = play;
  }

  public ValidRequestForPlay(User user, Playlist playlist, Play play) {
    this(play);
    condition.checkUser(user, playlist);
    condition.checkPlaylist(playlist, play);
  }

  public Play get() {
    return play;
  }
}
