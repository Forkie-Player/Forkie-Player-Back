package toolc.yourlist.playlist.domain;

public interface AllPlay {
  void save(Play play, long playlistSize);
  long havingCountOf(Long playlistId);
}
