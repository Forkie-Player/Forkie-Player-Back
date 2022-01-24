package toolc.yourlist.playlist.domain;

public class MockAllPlay implements AllPlay{
  @Override
  public void save(Play play, long playlistSize) {
  }

  @Override
  public long havingCountOf(Long playlistId) {
    return 0;
  }

  @Override
  public ListOfPlays readAllBelongsTo(Long playlistId) {
    return null;
  }
}
