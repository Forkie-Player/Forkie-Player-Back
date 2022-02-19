package toolc.yourlist.playlist.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class ValidRequestForPlaylist {
  private final Playlist playlist;
  private final static EqualCondition condition = new EqualCondition();

  private ValidRequestForPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public ValidRequestForPlaylist(Member member, Playlist playlist) {
    this(playlist);
    condition.checkMember(member, playlist);
  }

  public Playlist get() {
    return playlist;
  }
}
