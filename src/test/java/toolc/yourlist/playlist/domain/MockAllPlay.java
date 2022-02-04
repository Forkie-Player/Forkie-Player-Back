package toolc.yourlist.playlist.domain;

public class MockAllPlay implements AllPlay {
  @Override
  public void save(Play play) {
  }

  @Override
  public long havingCountOf(Long playlistId) {
    return 0;
  }

  @Override
  public Plays readAllBelongsTo(Long playlistId) {
    return null;
  }

  @Override
  public Play belongsTo(Long id) {
    return Play.builder()
      .id(id)
      .playlistId(1L)
      .sequence(1L)
      .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
      .time(new PlayTime(1000L, 3000L))
      .channel(new Channel("Music man", "man.png"))
      .build();
  }

  @Override
  public void updateTime(Long id, PlayTime time) {
  }
}
