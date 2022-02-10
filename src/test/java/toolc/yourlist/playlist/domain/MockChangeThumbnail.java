package toolc.yourlist.playlist.domain;

public class MockChangeThumbnail implements ChangeThumbnail {
  @Override
  public void changeForMakingFirstPlay(Long playlistId, String thumbnail, Long playlistSize) {
  }

  @Override
  public void changeForUpdateSequence(Play play, Long changeToSequence) {
  }
}
