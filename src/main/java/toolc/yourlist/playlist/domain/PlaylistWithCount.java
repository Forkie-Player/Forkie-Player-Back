package toolc.yourlist.playlist.domain;

public record PlaylistWithCount(
  Long id,
  String userCode,
  String title,
  String thumbnail,
  Long playCount
) {
  public PlaylistWithCount(Playlist playlist, Long playCount) {
    this(
      playlist.id(),
      playlist.userCode(),
      playlist.title(),
      playlist.thumbnail(),
      playCount);
  }
}
