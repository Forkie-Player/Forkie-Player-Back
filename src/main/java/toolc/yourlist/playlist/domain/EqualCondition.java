package toolc.yourlist.playlist.domain;

final class EqualCondition {
  void checkMember(Member member, Playlist playlist) {
    if (!member.id().equals(playlist.memberId())) {
      throw new NotOwnerException();
    }
  }

  void checkPlaylist(Playlist playlist, Play play) {
    if(!playlist.id().equals(play.playlistId())) {
      throw new NotInEqualPlaylistException();
    }
  }
}
