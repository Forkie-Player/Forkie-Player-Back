package toolc.yourlist.playlist.domain;

public interface ChangeThumbnail {
  void changeForMakingFirstPlay(Long playlistId, String thumbnail);
  void changeForUpdateSequence(Play play, Long changeToSequence);
  void changeForEmptyPlaylist(Long playlistId);
}
