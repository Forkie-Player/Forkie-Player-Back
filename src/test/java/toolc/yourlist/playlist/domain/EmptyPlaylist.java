package toolc.yourlist.playlist.domain;

public class EmptyPlaylist implements AllPlaylists {
  @Override
  public Playlists readAllBelongsTo(User user) {
    return null;
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return null;
  }

  @Override
  public boolean exist(Long id) {
    return false;
  }

  @Override
  public long havingCountOf(User user) {
    return 0;
  }

  @Override
  public void save(Playlist playlist) {
  }

  @Override
  public void updateTitleBelongsTo(Long playlistId, String title) {
  }

  @Override
  public void delete(Playlist playlist) {
  }

  @Override
  public void updateThumbnail(Long playlistId, String thumbnail) {
  }
}
