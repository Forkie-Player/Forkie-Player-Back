package toolc.yourlist.playlist.domain;

import java.util.Optional;

class EmptyPlaylist implements AllPlaylists {
  @Override
  public ListOfPlaylists readAllBelongsTo(Long memberId) {
    return null;
  }

  @Override
  public Optional<Playlist> readBelongsTo(Long id) {
    return Optional.empty();
  }

  @Override
  public long havingCountOf(Long memberId) {
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
}