package toolc.yourlist.playlist.domain;

public interface AllPlaylists {
  ListOfPlaylists readAllBelongsTo(Long memberId);

  Playlist readBelongsTo(Long id);

  boolean exist(Long id);

  long havingCountOf(Long memberId);

  void save(Playlist playlist);

  void updateTitleBelongsTo(Long playlistId, String title);

  void delete(Playlist playlist);
}
