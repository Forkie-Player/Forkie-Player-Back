package toolc.yourlist.playlist.domain;

public interface AllPlay {
  void save(Play play);
  long havingCountOf(Long playlistId);
  Plays readAllBelongsTo(Long playlistId);
  Play belongsTo(Long id);
  void updateTime(Long id, PlayTime time);
  void updateSequence(Long id, Long sequenceToChange);
}
