package toolc.yourlist.playlist.domain;

public interface ChangeThumbnail {
  void changeForMakingFirstPlay(Long playlistId, String thumbnail, Long playlistSize);
  void changeForUpdateSequence(Play play, Long changeToSequence);
}
