package toolc.yourlist.playlist.domain;

import toolc.yourlist.playlist.domain.exception.NotInEqualPlaylistException;
import toolc.yourlist.playlist.domain.exception.NotOwnerException;

final class EqualCondition {
  void checkUser(User user, Playlist playlist) {
    if (!user.code().equals(playlist.userCode())) {
      throw new NotOwnerException();
    }
  }

  void checkPlaylist(Playlist playlist, Play play) {
    if(!playlist.id().equals(play.playlistId())) {
      throw new NotInEqualPlaylistException();
    }
  }
}
